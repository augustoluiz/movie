package com.movie.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.movie.dao.exception.DAOException;
import com.movie.model.Sala;

public interface ISalaDAO {

    void insereSala(Sala sala) throws DAOException;
	void boolean removeSala(long id) throws DAOException;
	void boolean alteraSala(Sala sala) throws DAOException;
	List<Sala> consultaSalas() throws DAOException;

}
