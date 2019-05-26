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
	
	/*Insere o Filme no Banco de Dados*/
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
	
	/*Remove o Filme do Banco de Dados*/
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
	
	/*Lista todos os filmes pelo nome*/
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
	
	/*Lista todos os filmes em cartaz(que tenha a data de estreia menor que a data atual)*/
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
	
	/*Lista todos os filmes que serão lançados(que tenha a data de estreia maior que a data atual)*/
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
