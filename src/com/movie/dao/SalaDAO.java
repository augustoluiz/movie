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
	
	/*Insere a Sala no Banco de Dados*/
	@Override
	public void insereSala(Sala sala) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(sala);
		em.getTransaction().commit();
		em.close();
	}

	/*Remove a Sala do Banco de Dados*/
	@Override
	public void removeSala(long id) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Sala sala = em.find(Sala.class, id);
		em.getTransaction().begin();
		em.remove(sala);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Altera Sala no Banco de Dados*/
	@Override
	public void alteraSala(Sala sala) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(sala);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Retorna o nome da sala, buscando pelo id*/
	@Override
	public String consultaSalaPorId(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Sala sala = em.find(Sala.class, id);
		return sala.getNome();
	}
	
	/*Lista todas as salas*/
	@Override
	public List<Sala> consultaSalas() throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Sala> salas = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Sala> query = em.createQuery("SELECT s FROM Sala s ", Sala.class);
		salas = query.getResultList();
		em.close();
		
		return salas;
	}
	
}
