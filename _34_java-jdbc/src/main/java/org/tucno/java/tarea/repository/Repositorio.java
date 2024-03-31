package org.tucno.java.tarea.repository;

import java.util.List;

public interface Repositorio<T> {
    List<T> listar();

    T porId(Long id);

    void actualizar(T t);

    void crear(T t);

    void eliminar(Long id);
}
