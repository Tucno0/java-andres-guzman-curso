package org.tucno.apiservlet.webapp.jdbc.services;

import org.tucno.apiservlet.webapp.jdbc.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.jdbc.models.Categoria;
import org.tucno.apiservlet.webapp.jdbc.models.Producto;
import org.tucno.apiservlet.webapp.jdbc.repositories.CategoriaRepositoryImpl;
import org.tucno.apiservlet.webapp.jdbc.repositories.ProductoRepositoryJdbcImpl;
import org.tucno.apiservlet.webapp.jdbc.repositories.Repository;

import java.sql.Connection;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Optional;

public class ProductoServiceJdbcImpl implements ProductoService{
    private Repository<Producto> productoRepositoryJdbc;
    private Repository<Categoria> categoriaRepositoryJdbc;

    public ProductoServiceJdbcImpl(Connection connection) {
        this.productoRepositoryJdbc = new ProductoRepositoryJdbcImpl(connection);
        this.categoriaRepositoryJdbc = new CategoriaRepositoryImpl(connection);
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

    @Override
    public void guardar(Producto producto) {
        try {
            productoRepositoryJdbc.guardar(producto);
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepositoryJdbc.eliminar(id);
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return categoriaRepositoryJdbc.listar();
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        try {
            return Optional.ofNullable((Categoria) categoriaRepositoryJdbc.porId(id));
        } catch (SQLDataException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        try {
            categoriaRepositoryJdbc.guardar(categoria);
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminarCategoria(Long id) {
        try {
            categoriaRepositoryJdbc.eliminar(id);
        } catch (SQLDataException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
