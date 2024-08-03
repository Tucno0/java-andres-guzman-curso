package org.tucno.springboot.apirest.models.services;

import org.tucno.springboot.apirest.models.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
//    public Cliente findById(Long id);
//    public Cliente save(Cliente cliente);
//    public void delete(Long id);
}
