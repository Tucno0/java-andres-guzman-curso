package org.tucno.apiservlet.webapp.bootstrap.repositories;

import java.sql.SQLDataException;
import java.util.List;

public interface Repository<T> {
    List<T> listar() throws SQLDataException;
    T porId(Long id) throws SQLDataException;
    void guardar(T t) throws SQLDataException;
    void eliminar(Long id) throws SQLDataException;
}
