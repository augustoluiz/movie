package com.movie.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.movie.model.Filme;

public class FilmeDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-movie");
	private EntityManager em = emf.createEntityManager();
	
	public FilmeDAO() {
		
	}
	
	public boolean insereFilme(Filme filme) {
		em.getTransaction().begin();
		try {
			em.persist(filme);
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
	
	public boolean removeFilme(long id) {
		try {
			Filme f = em.find(Filme.class, id);
			em.getTransaction().begin();
			em.remove(f);
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
	
	public List<Filme> consultaFilmes(String nome){	
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f where nome like :nome ", Filme.class);
		query.setParameter("nome","%" +nome+"%");
		filmes = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return filmes;
	}
	
	public List<Filme> listaFilmesEmCartaz(Date data_atual){
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f where estreia <= :data_atual", Filme.class);
		query.setParameter("data_atual",data_atual);
		filmes = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return filmes;
	}
	
	public List<Filme> listaFilmesEmBreve(Date data_atual){
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f where estreia > :data_atual", Filme.class);
		query.setParameter("data_atual",data_atual);
		filmes = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return filmes;
	}
	 
}
