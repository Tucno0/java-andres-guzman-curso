package org.tucno.apiservlet.webapp.auth.repositories;

import jakarta.inject.Inject;
import org.tucno.apiservlet.webapp.auth.configs.MysqlConnection;
import org.tucno.apiservlet.webapp.auth.configs.Repository;
import org.tucno.apiservlet.webapp.auth.models.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {
    @Inject
    @MysqlConnection
    private Connection connection;

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
    public List<Usuario> listar() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuarios";

        try(
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        ) {
            while (resultSet.next()) {
                Usuario usuario = getUsuario(resultSet);
                usuarios.add(usuario);
            }
        }

        return usuarios;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        Usuario usuario = null;
        String query = STR."SELECT * FROM usuarios WHERE id = \{id}";

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
    public void guardar(Usuario usuario) throws SQLException {
        String query;

        if (usuario.getId() != null && usuario.getId() > 0) {
            query = STR."""
                UPDATE usuarios
                SET username = '\{usuario.getUsername()}', password = '\{usuario.getPassword()}', email = '\{usuario.getEmail()}'
                WHERE id = \{usuario.getId()}
            """;

        } else {
            query = STR."""
                INSERT INTO usuarios (username, password, email)
                VALUES ('\{usuario.getUsername()}', '\{usuario.getPassword()}', '\{usuario.getEmail()}')
            """;
        }

        try (
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String query = STR."DELETE FROM usuarios WHERE id = \{id}";

        try ( Statement statement = connection.createStatement() ) {
            statement.executeUpdate(query);
        }
    }

    private Usuario getUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(resultSet.getLong("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setPassword(resultSet.getString("password"));
        usuario.setEmail(resultSet.getString("email"));

        return usuario;
    }
}
