package org.tucno.java.jdbc;

import org.tucno.java.jdbc.models.Categoria;
import org.tucno.java.jdbc.models.Producto;
import org.tucno.java.jdbc.repository.ProductoRepositorio;
import org.tucno.java.jdbc.repository.Repositorio;
import org.tucno.java.jdbc.util.ConeccionBaseDeDatos;

import java.sql.Connection;
import java.util.Date;

public class _04_EjemploProductos {
    public static void main(String[] args) {
        try (Connection connection = ConeccionBaseDeDatos.getInstance()) {
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
            producto.setNombre("Mouse inalámbrico");
            producto.setPrecio(80.0);
            producto.setFechaRegistro(new Date());

            Categoria categoria = new Categoria();
            categoria.setId(3L);

            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("\nProducto guardado: " + producto);

            System.out.println("\nLista de productos: ");
            repositorio.listar().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
