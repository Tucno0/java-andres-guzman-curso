package org.tucno.webapp.jaxws.jaas.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jaxws.jaas.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Curso> listar() {
        return entityManager.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        if (curso.getId() != null && curso.getId() > 0) {
            entityManager.merge(curso);
        } else {
            entityManager.persist(curso);
        }

        return curso;
    }
}
