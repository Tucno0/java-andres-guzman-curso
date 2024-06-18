package org.tucno.apiservlet.webapp.jpa.services;

import jakarta.inject.Inject;
import org.tucno.apiservlet.webapp.jpa.configs.ProductoServicePrincipal;
import org.tucno.apiservlet.webapp.jpa.configs.Service;
import org.tucno.apiservlet.webapp.jpa.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.jpa.models.entities.Usuario;
import org.tucno.apiservlet.webapp.jpa.repositories.RepositoryJpa;
import org.tucno.apiservlet.webapp.jpa.repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@ProductoServicePrincipal
@Service
public class UsuarioServiceImpl implements UsuarioService  {
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) { // No es necesario poner la anotación @Named ya que solo hay una implementación de UsuarioRepository
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(usuario -> usuario.getPassword().equals(password));

        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            return usuarioRepository.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Usuario> porId(Long id) {
        try {
            return Optional.ofNullable(usuarioRepository.porId(id));
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Usuario usuario) {
        try {
            usuarioRepository.guardar(usuario);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioRepository.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
