package org.tucno.hibernateapp.repositories;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;

import java.util.List;

public class ClienteRepository implements CrudRepository<Cliente>{
    private EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
    }

    @Override
    public Cliente findById(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void save(Cliente entity) {
        // Si el id es nulo
        if (entity.getId() == null)
            entityManager.persist(entity); // Se crea un nuevo registro
        else
            entityManager.merge(entity); // Se actualiza un registro existente
    }

    @Override
    public void deleteById(Long id) {
        Cliente cliente = findById(id);
        if (cliente != null)
            entityManager.remove(cliente);
    }
}
