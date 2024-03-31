package org.tucno.java.tarea.repository;

import org.tucno.java.tarea.models.Usuario;
import org.tucno.java.tarea.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorioImpl implements Repositorio<Usuario> {

    private Connection getConnection() {
        return ConexionBaseDatos.getInstance();
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = new ArrayList<>();

        try (
            Connection conexion = getConnection();
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM usuarios")
        ) {
            while (resultado.next()) {
                Usuario usuario = crearUsuario(resultado);
                usuarios.add(usuario);
            }

            return usuarios;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Usuario porId(Long id) {
        Usuario usuario = null;

        try (
            Connection conexion = getConnection();
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM usuarios WHERE id = ?")
        ) {
            stmt.setLong(1, id);

            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    usuario = crearUsuario(resultado);
                }
            }

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public void actualizar(Usuario usuario) {
        try (
            Connection conexion = getConnection();
            PreparedStatement stmt = conexion.prepareStatement("UPDATE usuarios SET username = ?, password = ?, email = ? WHERE id = ?")
        ) {
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());
            stmt.setLong(4, usuario.getId());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void crear(Usuario usuario) {
        try (
            Connection conexion = getConnection();
            PreparedStatement stmt = conexion.prepareStatement("INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)")
        ) {
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setString(3, usuario.getEmail());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (
            Connection conexion = getConnection();
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM usuarios WHERE id = ?")
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Usuario crearUsuario(ResultSet resultado) throws SQLException {
        Usuario usuario = new Usuario();

        usuario.setId(resultado.getLong("id"));
        usuario.setUsername(resultado.getString("username"));
        usuario.setPassword(resultado.getString("password"));
        usuario.setEmail(resultado.getString("email"));

        return usuario;
    }
}
