package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _06_Between {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Buscar clientes cuyo id esté entre 2 y 4 ==============");
        List<Cliente> clientesPorId = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id BETWEEN 2 AND 4", Cliente.class)
                .getResultList();
        clientesPorId.forEach(System.out::println);

        System.out.println("\n============== Buscar clientes cuyo id no esté entre 2 y 4 ==============");
        List<Cliente> clientesPorIdNoEntre = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id NOT BETWEEN 2 AND 4", Cliente.class)
                .getResultList();
        clientesPorIdNoEntre.forEach(System.out::println);

        System.out.println("\n============== Buscar clientes cuyo id esté entre 2 y 4 y cuyo nombre empiece con 'd' ==============");
        List<Cliente> clientesPorIdYNombre = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id BETWEEN 2 AND 4 AND c.nombre LIKE 'd%'", Cliente.class)
                .getResultList();
        clientesPorIdYNombre.forEach(System.out::println);

        entityManager.close();
    }
}
