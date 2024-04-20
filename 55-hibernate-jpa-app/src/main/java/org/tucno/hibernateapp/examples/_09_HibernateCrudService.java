package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.services.ClienteService;
import org.tucno.hibernateapp.services.ClienteServiceImpl;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Optional;

public class _09_HibernateCrudService {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        ClienteService clienteService = new ClienteServiceImpl(entityManager);

        System.out.println("=========== Listado de clientes ===========");
        List<Cliente> clientes = clienteService.findAll();
        clientes.forEach(System.out::println);

        System.out.println("\n=========== Crear un nuevo cliente ===========");
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setFormaPago("Credito");
        clienteService.save(cliente);
        System.out.println("Cliente guardado: " + cliente);
        clienteService.findAll().forEach(System.out::println);

        System.out.println("\n=========== Buscar un cliente por ID ===========");
        Optional<Cliente> clienteOptional = clienteService.findById(1L);
        clienteOptional.ifPresent(System.out::println); // Es lo mismo que hacer: clienteOptional.ifPresent(cliente -> System.out.println(cliente));

        System.out.println("\n=========== Actualizar un cliente ===========");
        Long id = cliente.getId();
        clienteOptional = clienteService.findById(id);
        clienteOptional.ifPresent(c -> {
            c.setFormaPago("Yape");
            clienteService.save(c);
            System.out.println("Cliente actualizado: " + c);
            clienteService.findAll().forEach(System.out::println);
        });

        System.out.println("\n=========== Eliminar un cliente ===========");
        id = cliente.getId();
        clienteOptional = clienteService.findById(id);
        clienteOptional.ifPresent(c -> {
            clienteService.deleteById(c.getId());
            System.out.println("Cliente eliminado: " + c);
            clienteService.findAll().forEach(System.out::println);
        });

        // Cerramos la conexión al finalizar
        entityManager.close();
    }
}
