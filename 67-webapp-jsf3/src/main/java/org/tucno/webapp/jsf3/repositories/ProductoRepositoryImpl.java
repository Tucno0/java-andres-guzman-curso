package org.tucno.webapp.jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jsf3.entities.Producto;

import java.util.List;

@RequestScoped
public class ProductoRepositoryImpl implements CrudRepository<Producto> {
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Producto> listar() {
        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) {
        return entityManager.find(Producto.class, id);
    }
}
