package org.tucno.apiservlet.webapp.jpa.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.apiservlet.webapp.jpa.configs.Repository;
import org.tucno.apiservlet.webapp.jpa.models.entities.Producto;

import java.util.List;

@RepositoryJpa
@Repository
public class ProductoRepositoryJpaImpl implements  CrudRepository<Producto> {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Producto> listar() throws Exception {
        return entityManager.createQuery("from Producto", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) throws Exception {
        return entityManager.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) throws Exception {
        if (producto.getId() != null && producto.getId() > 0) {
            entityManager.merge(producto);
        } else {
            entityManager.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Producto producto = porId(id);
        entityManager.remove(producto);
    }
}
