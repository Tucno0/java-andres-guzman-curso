package org.tucno.webapp.jpa.ejb.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.tucno.webapp.jpa.ejb.configs.Repository;
import org.tucno.webapp.jpa.ejb.models.entities.Usuario;

import java.util.List;

@RepositoryJpa
@Repository
public class UsuarioRepositoryJpaImpl implements UsuarioRepository{
    @Inject
    private EntityManager entityManager;

    @Override
    public Usuario porUsername(String username) throws Exception {
        return entityManager.createQuery("select u from Usuario u where u.username = :username", Usuario.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    @Override
    public List<Usuario> listar() throws Exception {
        return entityManager.createQuery("select u from Usuario u", Usuario.class).getResultList();
    }

    @Override
    public Usuario porId(Long id) throws Exception {
        return entityManager.find(Usuario.class, id);
    }

    @Override
    public void guardar(Usuario usuario) throws Exception {
        if (usuario.getId() != null && usuario.getId() > 0) {
            entityManager.merge(usuario);
        } else {
            entityManager.persist(usuario);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Usuario usuario = porId(id);
        entityManager.remove(usuario);
    }
}
