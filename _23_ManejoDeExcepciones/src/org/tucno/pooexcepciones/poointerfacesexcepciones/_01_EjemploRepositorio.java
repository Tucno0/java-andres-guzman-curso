package org.tucno.pooexcepciones.poointerfacesexcepciones;

import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.AccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.EscrituraAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.LecturaAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.excepciones.RegistroDuplicadoAccesoDatoException;
import org.tucno.pooexcepciones.poointerfacesexcepciones.modelo.Cliente;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.Direccion;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.OrdenablePaginableCrudRepositorio;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.OrdenableRepositorio;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.PaginableRepositorio;
import org.tucno.pooexcepciones.poointerfacesexcepciones.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class _01_EjemploRepositorio {
    public static void main(String[] args) {
        try {
            OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            repo.crear(new Cliente("Andres", "Guzman"));
            repo.crear(new Cliente("Luci", "Martinez"));
            repo.crear(new Cliente("Pepe", "Fernandez"));

            Cliente cliente = new Cliente("Paco", "Gonzalez");
            repo.crear(cliente);

            // Se induce al error de duplicado
            repo.crear(cliente);

            // Se induce el error LecturaAccesoDatoException
//            repo.crear(null);

            List<Cliente> clientes = repo.listar();

            clientes.forEach(System.out::println); // Method reference

            System.out.println("\n===== paginable =====");
            List<Cliente> paginable = ((PaginableRepositorio) repo).listar(1, 4); // Downcasting - 3 no incluido
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
            // se induce el error LecturaAccesoDatoException por ID no existente
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

        // Los errores se capturan de más específico a más general
        } catch (RegistroDuplicadoAccesoDatoException e) {
            System.out.println("RegistroDuplicado: " + e.getMessage());
            e.printStackTrace();

        } catch (LecturaAccesoDatoException e) {
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();

        } catch (EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();

        } catch (AccesoDatoException e) {
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
