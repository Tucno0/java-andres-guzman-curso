package org.tucno.apiservlet.webapp.jdbc.repositories;

import org.tucno.apiservlet.webapp.jdbc.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository {
    private Connection connection;

    public ProductoRepositoryJdbcImpl(Connection connection) {
        if (connection == null) {
            throw new IllegalArgumentException("Connection cannot be null");
        }
        this.connection = connection;
    }

    @Override
    public List listar() throws SQLDataException {
        List<Producto> productos = new ArrayList<>();

        // Statement es una clase que se utiliza para ejecutar sentencias SQL
        try(Statement statement = connection.createStatement()) {
            //language=SQL
            String query = STR."""
                SELECT p.*, c.nombre as categoria FROM productos as p
                INNER JOIN categorias as c ON p.categoria_id = c.id
            """;

            // ResultSet es una clase que nos permite recorrer los resultados de una consulta SQL
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Producto producto = getProducto(resultSet);
                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Object porId(Long id) throws SQLDataException {
        Producto producto = null;

        try(Statement statement = connection.createStatement()) {
            //language=SQL
            String query = STR."""
                SELECT p.*, c.nombre as categoria FROM productos as p
                INNER JOIN categorias as c ON p.categoria_id = c.id
                WHERE p.id = \{id}
            """;

            try (ResultSet resultSet = statement.executeQuery(query)) {
                // Si hay un resultado
                if (resultSet.next()) {
                    producto = getProducto(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Object o) throws SQLDataException {

    }

    @Override
    public void eliminar(Long id) throws SQLDataException {

    }

    private Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setTipo(resultSet.getString("categoria"));
        return producto;
    }
}
