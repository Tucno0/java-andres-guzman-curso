package org.tucno.jdbc_pool.services;

import org.tucno.jdbc_pool.models.Categoria;
import org.tucno.jdbc_pool.models.Producto;
import org.tucno.jdbc_pool.repositories.CategoriaRepositorioImpl;
import org.tucno.jdbc_pool.repositories.ProductoRepositorioImpl;
import org.tucno.jdbc_pool.repositories.Repositorio;
import org.tucno.jdbc_pool.utils.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Servicio {
    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listarProductos() throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            productoRepositorio.setConexion(conexion);
            return productoRepositorio.listar();
        }
    }

    @Override
    public Producto porIdProducto(Long id) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            productoRepositorio.setConexion(conexion);
            return productoRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardarProducto(Producto producto) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            productoRepositorio.setConexion(conexion);

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            Producto nuevoProducto = null;

            try {
                nuevoProducto = productoRepositorio.guardar(producto);
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }

            return nuevoProducto;
        }
    }

    @Override
    public void eliminarProducto(Long id) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            productoRepositorio.setConexion(conexion);

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            try {
                productoRepositorio.eliminar(id);
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Categoria> listarCategorias() throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            categoriaRepositorio.setConexion(conexion);
            return categoriaRepositorio.listar();
        }
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            categoriaRepositorio.setConexion(conexion);
            return categoriaRepositorio.porId(id);
        }
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            categoriaRepositorio.setConexion(conexion);

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            Categoria nuevaCategoria = null;

            try {
                nuevaCategoria = categoriaRepositorio.guardar(categoria);
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }

            return nuevaCategoria;
        }
    }

    @Override
    public void eliminarCategoria(Long id) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            categoriaRepositorio.setConexion(conexion);

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            try {
                categoriaRepositorio.eliminar(id);
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto producto, Categoria categoria) throws SQLException {
        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            productoRepositorio.setConexion(conexion);
            categoriaRepositorio.setConexion(conexion);

            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            try {
                Categoria nuevaCategoria = categoriaRepositorio.guardar(categoria);
                producto.setCategoria(nuevaCategoria);
                productoRepositorio.guardar(producto);
                conexion.commit();
            } catch (SQLException e) {
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }
}
