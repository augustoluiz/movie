package com.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.movie.dao.connection.ConnectionBuilderORM;
import com.movie.dao.exception.DAOException;
import com.movie.dao.interfaces.IFilmeDAO;
import com.movie.model.Filme;

public class FilmeDAO implements IFilmeDAO{
	
	/*Insere o Filme no Banco de Dados*/
	@Override
	public void insereFilme(Filme filme) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(filme);
		em.getTransaction().commit();
		em.close();
	}

	/*Remove o Filme do Banco de Dados*/
	@Override
	public void removeFilme(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Filme filme = em.find(Filme.class, id);
		em.getTransaction().begin();
		em.remove(filme);
		em.getTransaction().commit();
		em.close();
	}

	/*Altera o Filme no Banco de Dados*/
	@Override
	public void alteraFilme(Filme filme) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(filme);
		em.getTransaction().commit();
		em.close();
	}

	/*Lista todos os filmes pelo nome*/
	@Override
	public List<Filme> consultaFilmes(String nome) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery(
				"SELECT f FROM Filme f where nome like :nome ", Filme.class);
		query.setParameter("nome","%" +nome+"%");
		filmes = query.getResultList();
		em.close();
		
		return filmes;
		
	}
	
	/*Consulta Filme pelo id*/
	@Override
	public Filme consultaFilme(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		
		em.getTransaction().begin();
		Filme filme = em.find(Filme.class, id);
		em.close();
		return filme;
	}
	
	/*Lista todos os filmes em cartaz(que tenha a data de estreia menor que a data atual)*/
	@Override
	public List<Filme> listaFilmesEmCartaz(Date data_atual) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f where estreia <= :data_atual", Filme.class);
		query.setParameter("data_atual",data_atual);
		filmes = query.getResultList();
		em.close();
		
		return filmes;
	}

	/*Lista todos os filmes que serão lançados(que tenha a data de estreia maior que a data atual)*/
	@Override
	public List<Filme> listaFilmesEmBreve(Date data_atual) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f where estreia > :data_atual", Filme.class);
		query.setParameter("data_atual",data_atual);
		filmes = query.getResultList();
		em.close();
		
		return filmes;
	}

	@Override
	public List<Filme> listaFilmesCadastrados() throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		
		List<Filme> filmes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f", Filme.class);
		filmes = query.getResultList();
		em.close();
		
		return filmes;
	}
	 
}
