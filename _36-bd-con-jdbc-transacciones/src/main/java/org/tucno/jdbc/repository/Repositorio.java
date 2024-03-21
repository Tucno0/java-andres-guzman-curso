package org.tucno.jdbc.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio <T> {
    // CRUD (Create, Read, Update, Delete)
    // Patron de diseño DAO (Data Access Object)
    // Este patrón de diseño se utiliza para separar la lógica de negocio de la lógica de persistencia de datos
    List<T> listar() throws SQLException;

    T porId(Long id) throws SQLException;

    void guardar(T t) throws SQLException;

    void eliminar(Long id) throws SQLException;
}
