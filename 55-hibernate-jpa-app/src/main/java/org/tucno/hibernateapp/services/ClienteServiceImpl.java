package org.tucno.hibernateapp.services;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.repositories.ClienteRepository;
import org.tucno.hibernateapp.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {
    private EntityManager entityManager;
    private CrudRepository<Cliente> repository;

    public ClienteServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.repository = new ClienteRepository(entityManager);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return Optional.ofNullable(repository.findById(id));
    }

    @Override
    public void save(Cliente entity) {
        try {
            entityManager.getTransaction().begin();
            repository.save(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            entityManager.getTransaction().begin();
            repository.deleteById(id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
