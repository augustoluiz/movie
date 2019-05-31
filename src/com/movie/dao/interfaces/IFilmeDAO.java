package com.movie.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.movie.dao.exception.DAOException;
import com.movie.model.Filme;

public interface IFilmeDAO {
	
	void insereFilme(Filme filme) throws DAOException;
	void removeFilme(long id) throws DAOException;
	void alteraFilme(Filme filme) throws DAOException;
	List<Filme> consultaFilmes(String nome) throws DAOException;
	List<Filme> listaFilmesEmCartaz(Date data_atual) throws DAOException;
	List<Filme> listaFilmesEmBreve(Date data_atual) throws DAOException;
	
}
