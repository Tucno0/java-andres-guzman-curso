package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _10_Subqueries {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Consultar el nombre mas corto y su longitud ==============");
        List<Object[]> resultado = entityManager.createQuery(
                "SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c WHERE LENGTH(c.nombre) = (SELECT MIN(LENGTH(c2.nombre)) FROM Cliente c2)", Object[].class)
                .getResultList();

        resultado.forEach(r -> System.out.println("Nombre: " + r[0] + ", Longitud: " + r[1]));

        System.out.println("\n============== Consultar el ultimo cliente registrado ==============");
        Cliente ultimoCliente = entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.id = (SELECT MAX(c2.id) FROM Cliente c2)", Cliente.class)
                .getSingleResult();

        System.out.println("Ultimo cliente registrado: " + ultimoCliente);

        System.out.println("\n============== Consulta where in ==============");
        List<Cliente> clientes = entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.id IN (SELECT c2.id FROM Cliente c2 WHERE c2.id < 3)", Cliente.class)
                .getResultList();

        clientes.forEach(System.out::println);

        entityManager.close();
    }
}
