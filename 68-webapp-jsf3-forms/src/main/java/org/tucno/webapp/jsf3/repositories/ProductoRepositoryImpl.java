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
        return entityManager.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN FETCH p.categoria", Producto.class)
                .getResultList();
    }

    @Override
    public Producto porId(Long id) {
//        return entityManager.find(Producto.class, id);
        return entityManager.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN FETCH p.categoria WHERE p.id = :id", Producto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void guardar(Producto producto) {
        if (producto.getId() != null && producto.getId() != 0)
            entityManager.merge(producto);
        else
            entityManager.persist(producto);
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = porId(id);
        entityManager.remove(producto);
    }
}
