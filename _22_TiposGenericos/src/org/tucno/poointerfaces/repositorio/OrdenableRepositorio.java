package org.tucno.poointerfaces.repositorio;

import org.tucno.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> listar(String campo, Direccion dir); // public abstract List<T> listar(String campo, Direccion dir);
}
