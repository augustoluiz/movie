package com.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.movie.dao.connection.ConnectionBuilderORM;
import com.movie.dao.exception.DAOException;
import com.movie.dao.interfaces.IProgramacaoDAO;
import com.movie.model.Programacao;

public class ProgramacaoDAO implements IProgramacaoDAO{

	/*Insere a programa��o no Banco de Dados*/
	@Override
	public void insereProgramacao(Programacao programacao) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Remove a programa��o do Banco de Dados*/
	@Override
	public void removeProgramacao(long id) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Programacao programacao = em.find(Programacai.class, id);
		em.getTransaction().begin();
		em.remove(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Altera a Programa��o no Banco de Dados*/
	@Override
	public void alteraProgramacao(Programacao programacao) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Retorna uma lista de programa��es por filme*/
	@Override
	public List<Programacao> consultaProgramacoes(long id_filme) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Programacao> programacoes = new ArrayList<>();
				
		em.getTransaction().begin();
		TypedQuery<Programacao> query = em.createQuery("SELECT p FROM Programacao p where id_filme like :id_filme ", Programacao.class);
		query.setParameter("id_filme",id_filme);
		programacoes = query.getResultList();
		em.close();
		
		return programacoes;
	}
	
	/*Busca em todas as programa��es(ap�s a data atual) do filme em quest�o, a qualidade (2D ou 3D)*/
	@Override
	public List<String> consultaQualidadePorFilme(long id_filme, Date data_atual) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<String> qualidade = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT p.qualidade FROM Programacao p where id_filme like :id_filme and exibicao > :data_atual", String.class);
		query.setParameter("id_filme",id_filme);
		query.setParameter("data_atual",data_atual);
		qualidade = query.getResultList();
		em.close();
		
		return qualidade;
	}
	
	/*Busca em todas as programa��es(ap�s a data atual) do filme em quest�o, o audio (LEG ou DUB)*/
	@Override
	public List<String> consultaAudioPorFilme(long id_filme, Date data_atual) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<String> audio = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT p.audio FROM Programacao p where id_filme like :id_filme and exibicao > :data_atual", String.class);
		query.setParameter("id_filme",id_filme);
		query.setParameter("data_atual",data_atual);
		audio = query.getResultList();
		em.close();
		
		return audio;
	}
	
}
