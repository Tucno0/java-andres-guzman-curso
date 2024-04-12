package org.tucno.apiservlet.webapp.auth.services;

import org.tucno.apiservlet.webapp.auth.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.auth.models.Usuario;
import org.tucno.apiservlet.webapp.auth.repositories.UsuarioRepository;
import org.tucno.apiservlet.webapp.auth.repositories.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService  {
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection connection) {
        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(usuario -> usuario.getPassword().equals(password));

        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
