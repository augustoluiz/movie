package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.movie.model.Usuario;

public class UsuarioDAO {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence-movie");
	private EntityManager em = emf.createEntityManager();
	
	public UsuarioDAO() {
		
	}
	
	/*Verifica se a senha e login estão cadastradas*/
	public boolean confereUsuario(String login, String senha) {
		List<Usuario> usuario = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where login like :login and senha like :senha", Usuario.class);
		query.setParameter("login",login.toUpperCase());
		query.setParameter("senha",senha.toUpperCase());
		usuario = query.getResultList();
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		if(usuario.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
}
