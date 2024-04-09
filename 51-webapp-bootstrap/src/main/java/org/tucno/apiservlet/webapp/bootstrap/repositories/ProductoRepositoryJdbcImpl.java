package org.tucno.apiservlet.webapp.bootstrap.repositories;

import org.tucno.apiservlet.webapp.bootstrap.models.Categoria;
import org.tucno.apiservlet.webapp.bootstrap.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {
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
                ORDER BY p.id ASC
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
    public Producto porId(Long id) throws SQLDataException {
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
    public void guardar(Producto producto) throws SQLDataException {
        String query;

        //language=SQL
        if (producto.getId() != null && producto.getId() > 0) {
            query = STR."""
                UPDATE productos SET nombre = '\{producto.getNombre()}', precio = '\{producto.getPrecio()}', categoria_id = '\{producto.getCategoria().getId()}', sku = '\{producto.getSku()}'
                WHERE id = \{producto.getId()}
            """;
        } else {
            query = STR."""
                INSERT INTO productos (nombre, precio, categoria_id, sku, fecha_registro)
                VALUES ('\{producto.getNombre()}', '\{producto.getPrecio()}', '\{producto.getCategoria().getId()}', '\{producto.getSku()}', '\{Date.valueOf(producto.getFechaRegistro())}')
            """;
        }

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLDataException {
        //language=SQL
        String query = STR."""
            DELETE FROM productos WHERE id = \{id}
        """;

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));

        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        producto.setCategoria(categoria);

        producto.setSku(resultSet.getString("sku"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());

        return producto;
    }
}
