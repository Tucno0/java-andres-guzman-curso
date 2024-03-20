package org.tucno.jdbc;

import org.tucno.jdbc.models.Categoria;
import org.tucno.jdbc.models.Producto;
import org.tucno.jdbc.repository.ProductoRepositorio;
import org.tucno.jdbc.repository.Repositorio;

public class _03_ActualizarProducto {
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

        // Actualizar un producto por su id
        Producto producto = new Producto();
        producto.setId(5L);
        producto.setNombre("Teclado Razer mecánico");
        producto.setPrecio(700.0);

        Categoria categoria = new Categoria();
        categoria.setId(3L);

        producto.setCategoria(categoria);

        repositorio.guardar(producto);
        System.out.println("\nProducto actualizado: " + producto);

        System.out.println("\nLista de productos: ");
        repositorio.listar().forEach(System.out::println);
    }
}
