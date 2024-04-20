package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _05_LikeStatements {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Buscar clientes por nombre ==============");
        String param = "hn";
        List<Cliente> clientesPorNombre = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombreBuscar", Cliente.class)
                .setParameter("nombreBuscar", "%" + param + "%")
                .getResultList();
        clientesPorNombre.forEach(System.out::println);

        System.out.println("\n============== Buscar clientes cuyo nombre empiece con 'd' ==============");
        param = "d";
        List<Cliente> clientesPorNombreEmpiezaCon = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombreBuscar", Cliente.class)
                .setParameter("nombreBuscar", param + "%")
                .getResultList();
        clientesPorNombreEmpiezaCon.forEach(System.out::println);

        entityManager.close();
    }
}
