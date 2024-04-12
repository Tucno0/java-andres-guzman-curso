package org.tucno.apiservlet.webapp.auth.repositories;

import org.tucno.apiservlet.webapp.auth.models.Usuario;

import java.sql.*;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository {
    private Connection connection;

    public UsuarioRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        String query = STR."SELECT * FROM usuarios WHERE username = '\{username}'";

        try (
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ) {
            if (resultSet.next()) {
                usuario = getUsuario(resultSet);
            }
        }

        return usuario;
    }


    @Override
    public List<Usuario> listar() throws SQLDataException {
        return List.of();
    }

    @Override
    public Usuario porId(Long id) throws SQLDataException {
        return null;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLDataException {

    }

    @Override
    public void eliminar(Long id) throws SQLDataException {

    }

    private Usuario getUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));

        return usuario;
    }
}
