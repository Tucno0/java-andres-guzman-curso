package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _07_OrderBy {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Consultar clientes ordenados por nombre ==============");
        List<Cliente> clientesPorNombre = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre", Cliente.class)
                .getResultList();
        clientesPorNombre.forEach(System.out::println);

        System.out.println("\n============== Consultar clientes ordenados por nombre de forma descendente ==============");
        List<Cliente> clientesPorNombreDesc = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre DESC", Cliente.class)
                .getResultList();
        clientesPorNombreDesc.forEach(System.out::println);

        System.out.println("\n============== Consultar clientes ordenados por id y luego por nombre ==============");
        List<Cliente> clientesPorIdYNombre = entityManager.createQuery("SELECT c FROM Cliente c ORDER BY c.id, c.nombre", Cliente.class)
                .getResultList();
        clientesPorIdYNombre.forEach(System.out::println);

        entityManager.close();
    }
}
