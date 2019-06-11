package com.movie.dao.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionBuilderORM {
	
	private static ConnectionBuilderORM instancia;
	private static EntityManagerFactory emf; 
	
	private ConnectionBuilderORM() {
		emf = Persistence.createEntityManagerFactory("persistence-movie");
	}
	
	public static ConnectionBuilderORM getInstance() {
		if(instancia == null || !emf.isOpen()) {
			instancia = new ConnectionBuilderORM();
		}
		return instancia;
	}
	
	public EntityManager getConnection() {
		return emf.createEntityManager();
	}
	
	public void closeConnection() {
		emf.close();
	}
	
}
