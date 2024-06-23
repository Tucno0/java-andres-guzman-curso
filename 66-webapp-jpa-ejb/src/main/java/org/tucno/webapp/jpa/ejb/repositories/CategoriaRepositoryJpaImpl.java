package org.tucno.webapp.jpa.ejb.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jpa.ejb.configs.Repository;
import org.tucno.webapp.jpa.ejb.models.entities.Categoria;

import java.util.List;

@RepositoryJpa
@Repository
public class CategoriaRepositoryJpaImpl implements CrudRepository<Categoria> {
    @Inject
    EntityManager entityManager;

    @Override
    public List<Categoria> listar() throws Exception {
        return entityManager.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) throws Exception {
        return entityManager.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) throws Exception {
        if (categoria.getId() != null && categoria.getId() > 0) {
            entityManager.merge(categoria);
        } else {
            entityManager.persist(categoria);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Categoria categoria = porId(id);
        entityManager.remove(categoria);
    }
}
