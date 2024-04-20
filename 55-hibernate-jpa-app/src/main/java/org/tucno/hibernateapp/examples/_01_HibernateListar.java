package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.List;

public class _01_HibernateListar {

    public static void main(String[] args) {
        // Se obtiene una instancia de EntityManager para interactuar con la base de datos a través de JPA
        EntityManager entityManager = JpaUtil.getEntityManager();

        // Se realiza una consulta JPQL para obtener todos los registros de la tabla Cliente
        List<Cliente> clientes = entityManager.createQuery("SELECT c FROM Cliente c, Cliente.class").getResultList();

        // Se recorre la lista de clientes y se imprimen en consola
        clientes.forEach(System.out::println);

        // Se cierra la instancia de EntityManager
        entityManager.close();
    }
}
