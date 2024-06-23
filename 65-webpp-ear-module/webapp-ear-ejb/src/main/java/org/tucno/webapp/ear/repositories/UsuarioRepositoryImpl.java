package org.tucno.webapp.ear.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.ear.entities.Usuario;

import java.util.List;

@RequestScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Inject
    private EntityManager entityManager;

    @Override
    public List<Usuario> listar() {
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
}
