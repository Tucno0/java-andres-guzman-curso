package org.tucno.webapp.jpa.ejb.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jpa.ejb.configs.Repository;
import org.tucno.webapp.jpa.ejb.models.entities.Producto;

import java.util.List;

@RepositoryJpa
@Repository
public class ProductoRepositoryJpaImpl implements  CrudRepository<Producto> {

    @Inject
    EntityManager entityManager;

    @Override
    public List<Producto> listar() throws Exception {
        return entityManager.createQuery("select p from Producto p left outer join fetch p.categoria", Producto.class).getResultList();
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
