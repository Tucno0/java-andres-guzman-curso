package org.tucno.springboot.app.models.services;

import org.tucno.springboot.app.models.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
