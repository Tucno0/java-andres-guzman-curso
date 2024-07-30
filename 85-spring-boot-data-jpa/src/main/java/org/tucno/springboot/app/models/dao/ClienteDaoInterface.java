package org.tucno.springboot.app.models.dao;

import org.tucno.springboot.app.models.entities.Cliente;

import java.util.List;

public interface ClienteDaoInterface {
    public List<Cliente> findAll();
    public void save(Cliente cliente);
    public Cliente findOne(Long id);
    public void delete(Long id);
}
