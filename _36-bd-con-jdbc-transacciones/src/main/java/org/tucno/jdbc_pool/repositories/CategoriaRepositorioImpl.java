package org.tucno.jdbc_pool.repositories;

import org.tucno.jdbc_pool.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements Repositorio<Categoria> {
    private Connection conexion;

    public CategoriaRepositorioImpl() {}

    public CategoriaRepositorioImpl(Connection conexion) {
        this.conexion = conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        try (
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM categorias");
        ){
            while (resultado.next()) {
                Categoria categoria = crearCategoria(resultado);
                categorias.add(categoria);
            }
        }

        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;

        try (
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM categorias WHERE id = ?")
        ){
            stmt.setLong(1, id);

            // try-with-resources para cerrar el ResultSet
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    categoria = crearCategoria(resultado);
                }
            }
        }

        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql;

        if (categoria.getId() != null && categoria.getId() > 0) {
            sql = STR."UPDATE categorias SET nombre = \"\{categoria.getNombre()}\" WHERE id = \{categoria.getId()}";
        } else {
            sql = STR."INSERT INTO categorias (nombre) VALUES (\"\{categoria.getNombre()}\")";
        }

        try ( PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) ){
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas == 0) {
                throw new SQLException("No se pudo guardar la categoria");
            }

            if (categoria.getId() == null) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        categoria.setId(generatedKeys.getLong(1));
                    } else {
                        throw new SQLException("No se pudo guardar la categoria, no se obtuvo el id generado");
                    }
                }
            }
        }

        return categoria;
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try ( PreparedStatement stmt = conexion.prepareStatement("DELETE FROM categorias WHERE id = ?") ){
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private static Categoria crearCategoria(ResultSet resultado) throws SQLException {
        Categoria categoria = new Categoria();

        categoria.setId(resultado.getLong("id"));
        categoria.setNombre(resultado.getString("nombre"));
        return categoria;
    }

}
