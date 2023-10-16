package org.tucno.pooexcepciones.poointerfacesexcepciones;

import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.AccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.LecturaAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.modelo.Cliente;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.Direccion;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.OrdenablePaginableCrudRepositorio;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class _02_EjemploRepositorioHerenciaInterfaces {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Andres", "Guzman"));
            repo.crear(new Cliente("Luci", "Martinez"));
            repo.crear(new Cliente("Pepe", "Fernandez"));
            repo.crear(new Cliente("Paco", "Gonzalez"));

            List<Cliente> clientes = repo.listar();

            clientes.forEach(System.out::println); // Method reference

            System.out.println("\n===== paginable =====");
            List<Cliente> paginable = repo.listar(1, 4); // Downcasting - 3 no incluido
            paginable.forEach(System.out::println);

            System.out.println("\n===== ordenar nombre ASC =====");
            List<Cliente> clientesOrdenAsc = repo.listar("nombre", Direccion.ASC);
            clientesOrdenAsc.forEach(System.out::println);

            System.out.println("\n===== ordenar nombre DESC =====");
            List<Cliente> clientesOrdenDesc = repo.listar("nombre", Direccion.DESC);
            clientesOrdenDesc.forEach(System.out::println);

            System.out.println("\n===== ordenar apellido ASC =====");
            List<Cliente> clientesOrdenApellidoAsc = repo.listar("apellido", Direccion.ASC);
            clientesOrdenApellidoAsc.forEach(System.out::println);

//            System.out.println("\n===== Editar =====");
//            Cliente pepeActualizar = new Cliente("Pepe", "Perez");
//            pepeActualizar.setId(3);
//            repo.editar(pepeActualizar);
//            Cliente pepe = repo.porId(3);
//            System.out.println(pepe);

            System.out.println("\n===== Eliminar =====");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

            System.out.println("\n===== Total =====");
            System.out.println("Total registros: " + repo.total());
        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
