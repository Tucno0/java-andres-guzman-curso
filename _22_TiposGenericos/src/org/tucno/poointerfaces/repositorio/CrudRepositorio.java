package org.tucno.poointerfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar(); // public abstract List<T> listar();
    T porId(Integer id); // public abstract T porId(Integer id);
    void crear(T t); // public abstract void crear(T cliente);
    void editar(T t); // public abstract void editar(T cliente);
    void eliminar(Integer id); // public abstract void eliminar(Integer id);
}
