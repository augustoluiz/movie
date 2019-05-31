package com.movie.dao.interfaces;

import com.movie.dao.exception.DAOException;

public interface IUsuarioDAO {
    
    void confereUsuario(String login, String senha) throws DAOException;

}
