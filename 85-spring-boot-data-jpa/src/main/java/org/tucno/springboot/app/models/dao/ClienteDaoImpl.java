package org.tucno.springboot.app.models.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tucno.springboot.app.models.entities.Cliente;

import java.util.List;

// @Repository es una anotación que se utiliza para marcar una clase como un bean de persistencia en la capa de acceso a datos
// Esto sirve para que Spring la reconozca y la inyecte en otras clases que la necesiten
@Repository
public class ClienteDaoImpl implements ClienteDaoInterface {

    // @PersistenceContext es una anotación que se utiliza para inyectar el EntityManager en el DAO (Data Access Object)
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> findAll() {
        return entityManager.createQuery("from Cliente").getResultList();
    }

    @Override
    public void save(Cliente cliente) {
        if (cliente.getId() != null && cliente.getId() > 0) {
            entityManager.merge(cliente);
        } else {
            entityManager.persist(cliente);
        }
    }

    @Override
    public Cliente findOne(Long id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
    }
}
