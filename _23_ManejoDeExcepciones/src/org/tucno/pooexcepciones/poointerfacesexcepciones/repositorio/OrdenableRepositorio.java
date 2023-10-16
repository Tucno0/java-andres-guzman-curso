package org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir); // public abstract List<T> listar(String campo, Direccion dir);
}
