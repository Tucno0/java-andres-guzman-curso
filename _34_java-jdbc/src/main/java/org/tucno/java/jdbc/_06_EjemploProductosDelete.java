package org.tucno.java.jdbc;

import org.tucno.java.jdbc.models.Producto;
import org.tucno.java.jdbc.repository.ProductoRepositorio;
import org.tucno.java.jdbc.repository.Repositorio;
import org.tucno.java.jdbc.util.ConeccionBaseDeDatos;

import java.sql.Connection;

public class _06_EjemploProductosDelete {
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

            // Eliminar un producto por su id
            repositorio.eliminar(4L);
            System.out.println("\nProducto eliminado con id = 4");

            System.out.println("\nLista de productos: ");
            repositorio.listar().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
