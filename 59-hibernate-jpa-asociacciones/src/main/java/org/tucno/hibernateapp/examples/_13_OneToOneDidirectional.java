package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.ClienteDetalle;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _13_OneToOneDidirectional {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Perez");
            cliente.setFormaPago("Tarjeta de crédito");

            ClienteDetalle detalle = new ClienteDetalle(true, 100L);

            cliente.addDetalle(detalle);

            entityManager.persist(cliente);
            entityManager.getTransaction().commit();

            System.out.println(cliente);
            System.out.println(detalle);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
