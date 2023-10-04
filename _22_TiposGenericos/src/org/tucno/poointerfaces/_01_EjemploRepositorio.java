package org.tucno.poointerfaces;

import org.tucno.poointerfaces.modelo.Cliente;
import org.tucno.poointerfaces.repositorio.*;
import org.tucno.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class _01_EjemploRepositorio {
    public static void main(String[] args) {
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear( new Cliente("Andres", "Guzman"));
        repo.crear( new Cliente("Luci", "Martinez"));
        repo.crear( new Cliente("Pepe", "Fernandez"));
        repo.crear( new Cliente("Paco", "Gonzalez"));

        List<Cliente> clientes = repo.listar();

        clientes.forEach(System.out::println); // Method reference

        System.out.println("\n===== paginable =====");
        List<Cliente> paginable = ((PaginableRepositorio) repo).listar(1,4); // Downcasting - 3 no incluido
        paginable.forEach(System.out::println);

        System.out.println("\n===== ordenar nombre ASC =====");
        List<Cliente> clientesOrdenAsc = ((OrdenableRepositorio) repo).listar("nombre", Direccion.ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("\n===== ordenar nombre DESC =====");
        List<Cliente> clientesOrdenDesc = ((OrdenableRepositorio) repo).listar("nombre", Direccion.DESC);
        clientesOrdenDesc.forEach(System.out::println);

        System.out.println("\n===== ordenar apellido ASC =====");
        List<Cliente> clientesOrdenApellidoAsc = ((OrdenableRepositorio) repo).listar("apellido", Direccion.ASC);
        clientesOrdenApellidoAsc.forEach(System.out::println);

        System.out.println("\n===== Editar =====");
        Cliente pepeActualizar = new Cliente("Pepe", "Perez");
        pepeActualizar.setId(3);
        repo.editar(pepeActualizar);
        Cliente pepe = repo.porId(3);
        System.out.println(pepe);

        System.out.println("\n===== Eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
