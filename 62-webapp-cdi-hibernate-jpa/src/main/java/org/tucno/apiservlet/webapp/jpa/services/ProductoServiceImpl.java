package org.tucno.apiservlet.webapp.jpa.services;

import jakarta.inject.Inject;

import org.tucno.apiservlet.webapp.jpa.configs.ProductoServicePrincipal;
import org.tucno.apiservlet.webapp.jpa.configs.Service;
import org.tucno.apiservlet.webapp.jpa.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.jpa.interceptors.TransactionalJpa;
import org.tucno.apiservlet.webapp.jpa.models.entities.Categoria;
import org.tucno.apiservlet.webapp.jpa.models.entities.Producto;
import org.tucno.apiservlet.webapp.jpa.repositories.CrudRepository;
import org.tucno.apiservlet.webapp.jpa.repositories.RepositoryJpa;

import java.util.List;
import java.util.Optional;

@Service
@ProductoServicePrincipal
@TransactionalJpa
public class ProductoServiceImpl implements ProductoService{
    @Inject
    @RepositoryJpa
    private CrudRepository<Producto> productoRepositoryJdbc;

    @Inject
    @RepositoryJpa
    private CrudRepository<Categoria> categoriaRepositoryJdbc;

    @Override
    public List<Producto> listar() {
        try {
            return productoRepositoryJdbc.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
//    @Logging // @Logging: Anotación de enlace de interceptor personalizada. Solo es para el método listar()
    public Optional<Producto> obtenerPorId(Long id) {
        try {
            // si el producto no existe, el método porId retorna un Optional empty
            return Optional.ofNullable((Producto) productoRepositoryJdbc.porId(id));
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            productoRepositoryJdbc.guardar(producto);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepositoryJdbc.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return categoriaRepositoryJdbc.listar();
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        try {
            return Optional.ofNullable((Categoria) categoriaRepositoryJdbc.porId(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardarCategoria(Categoria categoria) {
        try {
            categoriaRepositoryJdbc.guardar(categoria);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminarCategoria(Long id) {
        try {
            categoriaRepositoryJdbc.eliminar(id);
        } catch (Exception e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
