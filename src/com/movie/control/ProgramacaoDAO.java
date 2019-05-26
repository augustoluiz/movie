package com.movie.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.movie.model.Programacao;

public class ProgramacaoDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-movie");
	private EntityManager em = emf.createEntityManager();
	
	public ProgramacaoDAO(){
		
	}
	
	/*Insere a programação no Banco de Dados*/
	public boolean insereProgramacao(Programacao programacao) {
		em.getTransaction().begin();
		try {
			em.persist(programacao);
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
	
	/*Remove a programação do Banco de Dados*/
	public boolean removeProgramacao(long id) {
		try {
			Programacao p = em.find(Programacao.class, id);
			em.getTransaction().begin();
			em.remove(p);
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
	
	/*Retorna uma lista de programações por filme*/
	public List<Programacao> consultaProgramacoes(long id_filme){
		List<Programacao> programacoes = new ArrayList<>();
				
		em.getTransaction().begin();
		TypedQuery<Programacao> query = em.createQuery("SELECT p FROM Programacao p where id_filme like :id_filme ", Programacao.class);
		query.setParameter("id_filme",id_filme);
		programacoes = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return programacoes;
		
	}
	
	/*Busca em todas as programações(após a data atual) do filme em questão, a qualidade (2D ou 3D)*/
	public List<String> consultaQualidadePorFilme(long id_filme, Date data_atual){		
		List<String> qualidade = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT p.qualidade FROM Programacao p where id_filme like :id_filme and exibicao > :data_atual", String.class);
		query.setParameter("id_filme",id_filme);
		query.setParameter("data_atual",data_atual);
		qualidade = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return qualidade;
	}
	
	/*Busca em todas as programações(após a data atual) do filme em questão, o audio (LEG ou DUB)*/
	public List<String> consultaAudioPorFilme(long id_filme, Date data_atual){
		List<String> audio = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<String> query = em.createQuery("SELECT DISTINCT p.audio FROM Programacao p where id_filme like :id_filme and exibicao > :data_atual", String.class);
		query.setParameter("id_filme",id_filme);
		query.setParameter("data_atual",data_atual);
		audio = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return audio;
	}
}
