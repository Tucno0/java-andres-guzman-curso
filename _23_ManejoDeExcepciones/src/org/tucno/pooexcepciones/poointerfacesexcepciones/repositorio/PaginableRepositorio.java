package org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar(int desde, int hasta); // public abstract List<Cliente> listar(int desde, int hasta);
}
