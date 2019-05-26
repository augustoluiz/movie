package com.movie.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.movie.model.Sala;

public class SalaDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-movie");
	private EntityManager em = emf.createEntityManager();
	
	public SalaDAO() {
		
	}
	
	public boolean insereSala(Sala sala) {
		em.getTransaction().begin();
		try {
			em.persist(sala);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			em.close();
			emf.close();
			return false;
		}
	}
	
	public boolean removeSala(long id) {
		try {
			Sala s = em.find(Sala.class, id);
			em.getTransaction().begin();
			em.remove(s);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			em.close();
			emf.close();
			return false;
		}
	}
	
	public List<Sala> consultaSalas(){
		List<Sala> salas = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Sala> query = em.createQuery("SELECT s FROM Sala s ", Sala.class);
		salas = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return salas;
	}
}
