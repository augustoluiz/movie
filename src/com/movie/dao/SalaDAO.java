package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.movie.dao.connection.ConnectionBuilderORM;
import com.movie.dao.exception.DAOException;
import com.movie.dao.interfaces.ISalaDAO;
import com.movie.model.Sala;

public class SalaDAO implements ISalaDAO{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-movie");
	private EntityManager em = emf.createEntityManager();
	
	/*Insere a Sala no Banco de Dados*/
	@Override
	void insereSala(Sala sala) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(sala);
		em.getTransaction().commit();
		em.close();
	}

	/*Remove a Sala do Banco de Dados*/
	@Override
	void boolean removeSala(long id) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Sala sala = em.find(Sala.class, id);
		em.getTransaction().begin();
		em.remove(sala);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Altera Sala no Banco de Dados*/
	@Override
	void boolean alteraSala(Sala sala) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(sala);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Lista todas as salas*/
	@Override
	List<Sala> consultaSalas() throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Sala> salas = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Sala> query = em.createQuery("SELECT s FROM Sala s ", Sala.class);
		salas = query.getResultList();
		em.close();
		
		return salas;
	}
	
}
