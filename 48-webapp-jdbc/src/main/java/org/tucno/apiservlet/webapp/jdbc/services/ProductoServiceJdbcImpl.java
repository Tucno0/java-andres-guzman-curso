package org.tucno.apiservlet.webapp.jdbc.services;

import org.tucno.apiservlet.webapp.jdbc.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.jdbc.models.Producto;
import org.tucno.apiservlet.webapp.jdbc.repositories.ProductoRepositoryJdbcImpl;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImpl implements ProductoService{
    private ProductoRepositoryJdbcImpl productoRepositoryJdbc;

    public ProductoServiceJdbcImpl(Connection connection) {
        this.productoRepositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
    }

    @Override
    public List<Producto> listar() {
        try {
            return productoRepositoryJdbc.listar();
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        try {
            // si el producto no existe, el método porId retorna un Optional empty
            return Optional.ofNullable((Producto) productoRepositoryJdbc.porId(id));
        } catch (SQLDataException e) {
            throw new RuntimeException(e);

        }
    }
}
