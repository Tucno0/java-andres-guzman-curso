package org.tucno.hibernateapp.services;

import org.tucno.hibernateapp.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    void save(Cliente entity);
    void deleteById(Long id);
}
