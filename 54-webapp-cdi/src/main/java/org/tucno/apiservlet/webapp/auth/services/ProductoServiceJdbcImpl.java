package org.tucno.apiservlet.webapp.auth.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import jakarta.inject.Named;
import org.tucno.apiservlet.webapp.auth.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.auth.models.Categoria;
import org.tucno.apiservlet.webapp.auth.models.Producto;
import org.tucno.apiservlet.webapp.auth.repositories.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Named("default")
public class ProductoServiceJdbcImpl implements ProductoService{
    @Inject
    private Repository<Producto> productoRepositoryJdbc;
    @Inject
    private Repository<Categoria> categoriaRepositoryJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return productoRepositoryJdbc.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        try {
            // si el producto no existe, el método porId retorna un Optional empty
            return Optional.ofNullable((Producto) productoRepositoryJdbc.porId(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            productoRepositoryJdbc.guardar(producto);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepositoryJdbc.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return categoriaRepositoryJdbc.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        try {
            return Optional.ofNullable((Categoria) categoriaRepositoryJdbc.porId(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        try {
            categoriaRepositoryJdbc.guardar(categoria);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminarCategoria(Long id) {
        try {
            categoriaRepositoryJdbc.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
