package org.tucno.jdbc;

import org.tucno.jdbc.models.Categoria;
import org.tucno.jdbc.models.Producto;
import org.tucno.jdbc.repository.ProductoRepositorio;
import org.tucno.jdbc.repository.Repositorio;
import org.tucno.jdbc.util.ConeccionBaseDeDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class _01_JdbcTransacciones {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConeccionBaseDeDatos.getInstance()) {
            // Se deshabilita el autocommit para poder realizar transacciones
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {
                // Se crea un objeto repositorio para la clase Producto
                Repositorio<Producto> repositorio = new ProductoRepositorio();

                // Obtener la lista de productos
                System.out.println("Lista de productos: ");
                repositorio.listar().forEach(System.out::println);

                // Obtener un producto por su id
                System.out.println("\nProducto con id = 1: ");
                System.out.println(repositorio.porId(1L));

                // Crear un nuevo producto
                Producto producto = new Producto();
                producto.setNombre("Teclado IBM inalámbrico");
                producto.setPrecio(1550.0);
                producto.setFechaRegistro(new Date());

                Categoria categoria = new Categoria();
                categoria.setId(3L);

                producto.setCategoria(categoria);
                producto.setSku("IBM-TECLADO");

                repositorio.guardar(producto);

                System.out.println("\nLista de productos: ");
                repositorio.listar().forEach(System.out::println);

                // Actualizar un producto por su id
                producto = new Producto();
                producto.setId(5L);
                producto.setNombre("Teclado Razer mecánico");
                producto.setPrecio(700.0);

                categoria = new Categoria();
                categoria.setId(3L);

                producto.setCategoria(categoria);
                producto.setSku("abcde123456");

                repositorio.guardar(producto);

                System.out.println("\nLista de productos: ");
                repositorio.listar().forEach(System.out::println);

                // Se confirma la transacción
                connection.commit();

            } catch (SQLException e) {
                // Se deshace la transacción
                connection.rollback();

                e.printStackTrace();
            }
        }
    }
}
