package org.tucno.poointerfaces.repositorio;

import org.tucno.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta); // public abstract List<Cliente> listar(int desde, int hasta);
}
