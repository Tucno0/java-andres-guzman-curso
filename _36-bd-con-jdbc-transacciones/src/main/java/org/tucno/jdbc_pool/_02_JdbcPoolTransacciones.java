package org.tucno.jdbc_pool;

import org.tucno.jdbc_pool.models.Categoria;
import org.tucno.jdbc_pool.models.Producto;
import org.tucno.jdbc_pool.repositories.CategoriaRepositorioImpl;
import org.tucno.jdbc_pool.repositories.ProductoRepositorioImpl;
import org.tucno.jdbc_pool.repositories.Repositorio;
import org.tucno.jdbc_pool.utils.ConexionBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class _02_JdbcPoolTransacciones {
    public static void main(String[] args) throws SQLException {

        try (Connection conexion = ConexionBaseDeDatos.getConnection()) {
            // Deshabilitar el modo de auto-commit si está habilitado
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }

            try {
                // Se crea un objeto repositorio para la clase Producto
                Repositorio<Producto> repositorioProducto = new ProductoRepositorioImpl(conexion);
                // Se crea un objeto repositorio para la clase Categoria
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conexion);

                //------------ Obtener la lista de categorías ------------
                System.out.println("Lista de categorías: ");
                repositorioCategoria.listar().forEach(System.out::println);

                //------------ Obtener una categoría por su id ------------
                System.out.println("\nCategoría con id = 1: ");
                System.out.println(repositorioCategoria.porId(1L));

                //------------ Crear una nueva categoría ------------
                Categoria categoria = new Categoria();
                categoria.setNombre("Electrodomésticos");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("\nCategoría guardada: " + nuevaCategoria);

                //------------ Obtener la lista de productos ------------
                System.out.println("Lista de productos: ");
                repositorioProducto.listar().forEach(System.out::println);

                //------------ Obtener un producto por su id ------------
                System.out.println("\nProducto con id = 1: ");
                System.out.println(repositorioProducto.porId(1L));

                //------------ Crear un nuevo producto ------------
                Producto producto = new Producto();
                producto.setNombre("Refrigeradora Samsung");
                producto.setPrecio(9900.0);
                producto.setFechaRegistro(new Date());
                producto.setSku("REFSAMSUNG001");
                producto.setCategoria(nuevaCategoria);

                repositorioProducto.guardar(producto);
                System.out.println("\nProducto guardado: " + producto);

                System.out.println("\nLista de productos: ");
                repositorioProducto.listar().forEach(System.out::println);

                // Si no ocurre ningún error, se confirman los cambios
                conexion.commit();

            } catch (SQLException e) {
                // Si ocurre un error, se deshacen los cambios
                conexion.rollback();
                e.printStackTrace();
            }
        }
    }
}
