package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.dtos.ClienteDto;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _01_HibernateQL {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("============== Listar todos los clientes ==============");
        List<Cliente> clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n============== Consultar cliente por id ==============");
        Cliente cliente = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id = :id", Cliente.class)
                .setParameter("id", 1L) // setParameter es para evitar SQL Injection y para que el query sea reutilizable
                .getSingleResult(); // getSingleResult es para obtener un solo resultado
        System.out.println(cliente);

        System.out.println("\n============== Consultar solo el nombre del cliente por id ==============");
        String nombre = entityManager.createQuery("SELECT c.nombre FROM Cliente c WHERE c.id = :id", String.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(nombre);

        System.out.println("\n============== Consultar por campos personalizados por Id ==============");
        Object[] camposPersonalizadosPorId = entityManager.createQuery("SELECT c.id, c.nombre FROM Cliente c WHERE c.id = :id", Object[].class)
                .setParameter("id", 1L)
                .getSingleResult();
        Long id = (Long) camposPersonalizadosPorId[0];
        String nombrePorId = (String) camposPersonalizadosPorId[1];
        System.out.println("id: " + id + ", nombre: " + nombrePorId);

        System.out.println("\n============== Consultar por campos personalizados ==============");
        List<Object[]> camposPersonalizados = entityManager.createQuery("SELECT c.id, c.nombre FROM Cliente c", Object[].class).getResultList();
        camposPersonalizados.forEach(c -> System.out.println("id: " + c[0] + ", nombre: " + c[1]));

        System.out.println("\n============== Consultar por Cliente y forma de pago ==============");
        List<Object[]> registros = entityManager.createQuery("SELECT c, c.formaPago FROM Cliente c", Object[].class).getResultList();
        registros.forEach(r -> {
            Cliente c = (Cliente) r[0];
            String formaPago = (String) r[1];
            System.out.println("Cliente: " + c + ", Forma de pago: " + formaPago);
        });

        System.out.println("\n============== Consulta que puebla y devuelve un objeto de una clase personalizada ==============");
        List<Cliente> clientes2 = entityManager.createQuery("SELECT NEW Cliente(c.nombre, c.apellido) FROM Cliente c", Cliente.class).getResultList();
        clientes2.forEach(System.out::println);

        System.out.println("\n============== Consulta que puebla y devuelve un objeto DTO  ==============");
        List<ClienteDto> clientesDto = entityManager.createQuery("SELECT NEW org.tucno.hibernateapp.dtos.ClienteDto(c.nombre, c.apellido) FROM Cliente c", ClienteDto.class).getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("\n============== Consulta solo los nombres de los clientes ==============");
        List<String> nombres = entityManager.createQuery("SELECT c.nombre FROM Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        entityManager.close();
    }
}
