package org.tucno.webapp.jaxrs.jaas.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jaxrs.jaas.models.Curso;

import java.util.List;

@RequestScoped
public class CursoRepositoryImpl implements CursoRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Curso> listar() {
        // Se utiliza left outer join para traer los instructores asociados a los cursos.
        // Hacer esto solucionará el problema de la excepción LazyInitializationException.
        return entityManager.createQuery("SELECT c FROM Curso c left outer join fetch c.instructor", Curso.class).getResultList();
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

    @Override
    public Curso porId(Long id) {
//        return entityManager.find(Curso.class, id);
        return entityManager.createQuery("SELECT c FROM Curso c left outer join fetch c.instructor WHERE c.id = :id", Curso.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void eliminar(Long id) {
        Curso curso = porId(id);
        entityManager.remove(curso);
    }
}
