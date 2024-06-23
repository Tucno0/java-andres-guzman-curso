package org.tucno.webapp.jpa.ejb.repositories;

import jakarta.inject.Inject;
import org.tucno.webapp.jpa.ejb.configs.MysqlConnection;
import org.tucno.webapp.jpa.ejb.configs.Repository;
import org.tucno.webapp.jpa.ejb.models.entities.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RepositoryJdbc
public class UsuarioRepositoryJdbcImpl implements UsuarioRepository {
    @Inject
    @MysqlConnection
    private Connection connection;

    @Override
    public Usuario porUsername(String username) throws SQLException {
        Usuario usuario = null;
        String query = """
            SELECT * FROM usuarios WHERE username = '%s'
        """.formatted(username);

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
        String query = "SELECT * FROM usuarios WHERE id = %d".formatted(id);

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
            query = """
                UPDATE usuarios
                SET username = '%s', password = '%s', email = '%s'
                WHERE id = %d
            """.formatted(usuario.getUsername(), usuario.getPassword(), usuario.getEmail(), usuario.getId());

        } else {
            query = """
                INSERT INTO usuarios (username, password, email)
                VALUES ('%s', '%s', '%s')
            """.formatted(usuario.getUsername(), usuario.getPassword(), usuario.getEmail());
        }

        try (
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String query = "DELETE FROM usuarios WHERE id = %d".formatted(id);

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
