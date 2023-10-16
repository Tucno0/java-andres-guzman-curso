package org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio;

import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.AccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.EscrituraAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar(); // public abstract List<T> listar();
    // se pone throws AccesoDatoException porque en la clase AbstractaListRepositorio se implementa el error hijo (LecturaAccesoDatoException)
    T porId(Integer id) throws AccesoDatoException; // public abstract T porId(Integer id);
    void crear(T t) throws AccesoDatoException; // public abstract void crear(T cliente);
    void editar(T t) throws AccesoDatoException; // public abstract void editar(T cliente);
    void eliminar(Integer id) throws AccesoDatoException; // public abstract void eliminar(Integer id);
}
