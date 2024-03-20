package org.tucno.java.jdbc_close;

import org.tucno.java.jdbc_close.models.Producto;
import org.tucno.java.jdbc_close.repository.ProductoRepositorio;
import org.tucno.java.jdbc_close.repository.Repositorio;

public class _05_EjemploProductosDelete {
    public static void main(String[] args) {
        // LA CONEXIÓN A LA BASE DE DATOS SE CIERRA AUTOMÁTICAMENTE AL TERMINAR CADA BLOQUE

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

    }
}
