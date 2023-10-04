package org.tucno.poointerfaces;

import org.tucno.poointerfaces.modelo.Cliente;
import org.tucno.poointerfaces.modelo.Producto;
import org.tucno.poointerfaces.repositorio.Direccion;
import org.tucno.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.tucno.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.tucno.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class _03_EjemploRepositorioProducto {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 50.00));
        repo.crear(new Producto("silla", 20.00));
        repo.crear(new Producto("lampara", 70.00));
        repo.crear(new Producto("notebook", 500.00));
        repo.crear(new Producto("teclado", 30.00));

        List<Producto> clientes = repo.listar();

        clientes.forEach(System.out::println); // Method reference

        System.out.println("\n===== paginable =====");
        List<Producto> paginable = repo.listar(1,4); // Downcasting - 3 no incluido
        paginable.forEach(System.out::println);

        System.out.println("\n===== ordenar descripcion ASC =====");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("\n===== Editar =====");
        Producto lamparaActualizar = new Producto("Lampara escritorio", 70.00);
        lamparaActualizar.setId(3);
        repo.editar(lamparaActualizar);
        Producto lampara = repo.porId(3);
        System.out.println(lampara);

        System.out.println("\n===== Eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("\n===== Total =====");
        System.out.println("Total registros: " + repo.total());
    }
}
