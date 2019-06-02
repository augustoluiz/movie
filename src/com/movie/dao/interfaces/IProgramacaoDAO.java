package com.movie.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.movie.dao.exception.DAOException;
import com.movie.model.Programacao;

public interface IProgramacaoDAO {

    void insereProgramacao(Programacao programacao) throws DAOException;
	void removeProgramacao(long id) throws DAOException;
	void alteraProgramacao(Programacao programacao) throws DAOException;
	List<Programacao> consultaProgramacoes(long id_filme) throws DAOException;
	List<Programacao> consultaProximasProgramacoes(long id_filme, Date data_atual) throws DAOException;
	List<String> consultaQualidadePorFilme(long id_filme, Date data_atual) throws DAOException;
	List<String> consultaAudioPorFilme(long id_filme, Date data_atual) throws DAOException;

}
