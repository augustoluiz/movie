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

	/*Insere a programacao no Banco de Dados*/
	@Override
	public void insereProgramacao(Programacao programacao) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.persist(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Remove a programacao do Banco de Dados*/
	@Override
	public void removeProgramacao(long id) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Programacao programacao = em.find(Programacao.class, id);
		em.getTransaction().begin();
		em.remove(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Altera a Programacao no Banco de Dados*/
	@Override
	public void alteraProgramacao(Programacao programacao) throws DAOException{
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		em.getTransaction().begin();
		em.merge(programacao);
		em.getTransaction().commit();
		em.close();
	}
	
	/*Retorna uma lista de programacoes por filme*/
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
	
	/*Consulta futuras programacoes do filme em questao*/
	@Override
	public List<Programacao> consultaProximasProgramacoes(long id_filme, Date data_atual) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Programacao> programacoes = new ArrayList<>();
				
		em.getTransaction().begin();
		TypedQuery<Programacao> query = em.createQuery("SELECT p FROM Programacao p where id_filme like :id_filme and exibicao > :data_atual", Programacao.class);
		query.setParameter("id_filme",id_filme);
		query.setParameter("data_atual",data_atual);
		programacoes = query.getResultList();
		em.close();
		
		return programacoes;
	}
	
	/*Busca em todas as programacoes(apos a data atual) do filme em questao, a qualidade (2D ou 3D)*/
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
	
	/*Busca em todas as programacoes(apos a data atual) do filme em questao, o audio (LEG ou DUB)*/
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

	/*Retorna se uma determinada sala esta associada a alguma programacao*/
	@Override
	public boolean consultaSalaPorProgramacao(long id_sala) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Programacao> programacoes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Programacao> query = em.createQuery("SELECT p FROM Programacao p where id_sala like :id_sala", Programacao.class);
		query.setParameter("id_sala",id_sala);
		programacoes = query.getResultList();
		em.close();
		
		if(!programacoes.isEmpty()) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean consultaFilmePorProgramacao(long id_filme) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		Long qtd_programacoes = 0l;
		
		em.getTransaction().begin();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Programacao p where id_filme like :id_filme", Long.class);
		query.setParameter("id_filme",id_filme);
		qtd_programacoes = query.getSingleResult();
		em.close();
		
		if(qtd_programacoes > 0) {
			return true;
		}
		
		return false;
	}

	/*Retorna o id_filme com base no id da programacao*/
	@Override
	public long consultaIdFilme(long id) throws DAOException {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Programacao> programacoes = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Programacao> query = em.createQuery("SELECT p FROM Programacao p where id like :id", Programacao.class);
		query.setParameter("id",id);
		programacoes = query.getResultList();
		em.close();
		
		return programacoes.get(0).getId_filme();
	}
	
}
