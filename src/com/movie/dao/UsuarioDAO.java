package com.movie.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.movie.dao.connection.ConnectionBuilderORM;
import com.movie.dao.interfaces.IUsuarioDAO;
import com.movie.model.Usuario;

public class UsuarioDAO implements IUsuarioDAO{
	
	/*Verifica se a senha e login estao cadastradas*/
	@Override
	public void confereUsuario(String login, String senha) {
		EntityManager em = ConnectionBuilderORM.getInstance().getConnection();
		List<Usuario> usuario = new ArrayList<>();
		
		em.getTransaction().begin();
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where login like :login and senha like :senha", Usuario.class);
		query.setParameter("login",login.toUpperCase());
		query.setParameter("senha",senha.toUpperCase());
		usuario = query.getResultList();
		em.close();

	}
	
}
