package com.movie.dao.interfaces;

import java.util.List;

import com.movie.dao.exception.DAOException;
import com.movie.model.Sala;

public interface ISalaDAO {

    void insereSala(Sala sala) throws DAOException;
	void removeSala(long id) throws DAOException;
	void alteraSala(Sala sala) throws DAOException;
	String consultaSalaPorId(long id) throws DAOException;
	List<Sala> consultaSalas() throws DAOException;

}
