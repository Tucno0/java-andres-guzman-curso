package org.tucno.apiservlet.webapp.jdbc.repositories;

import org.tucno.apiservlet.webapp.jdbc.models.Categoria;
import org.tucno.apiservlet.webapp.jdbc.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements Repository<Categoria>{
    private Connection connection;

    public CategoriaRepositoryImpl(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.connection = connection;
    }

    @Override
    public List<Categoria> listar() throws SQLDataException {
        List<Categoria> categorias = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            //language=SQL
            String query = """
                SELECT * FROM categorias
            """;

            // ResultSet es una clase que nos permite recorrer los resultados de una consulta SQL
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Categoria categoria = getCategoria(resultSet);
                categorias.add(categoria);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categorias;
    }

    @Override
    public Categoria porId(Long id) throws SQLDataException {
        Categoria categoria = null;

        try (Statement statement = connection.createStatement()) {
            //language=SQL
            String query = STR."""
                SELECT * FROM categorias
                WHERE id = \{id}
            """;

            try (ResultSet resultSet = statement.executeQuery(query)) {
                if (resultSet.next()) {
                    categoria = getCategoria(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLDataException {

    }

    @Override
    public void eliminar(Long id) throws SQLDataException {

    }

    private Categoria getCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("id"));
        categoria.setNombre(resultSet.getString("nombre"));

        return categoria;
    }

}
