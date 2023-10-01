package org.tucno.poointerfaces.repositorio;

import org.tucno.poointerfaces.modelo.Cliente;

import java.util.List;

public interface CrudRepositorio {
    List<Cliente> listar(); // public abstract List<Cliente> listar();
    Cliente porId(Integer id); // public abstract Cliente porId(Integer id);
    void crear(Cliente cliente); // public abstract void crear(Cliente cliente);
    void editar(Cliente cliente); // public abstract void editar(Cliente cliente);
    void eliminar(Integer id); // public abstract void eliminar(Integer id);
}
