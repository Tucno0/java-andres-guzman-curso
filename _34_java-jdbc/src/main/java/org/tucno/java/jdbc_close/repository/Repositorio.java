package org.tucno.java.jdbc_close.repository;

import java.util.List;

public interface Repositorio <T> {
    // CRUD (Create, Read, Update, Delete)
    // Patron de diseño DAO (Data Access Object)
    // Este patrón de diseño se utiliza para separar la lógica de negocio de la lógica de persistencia de datos
    List<T> listar();

    T porId(Long id);

    void guardar(T t);

    void eliminar(Long id);
}
