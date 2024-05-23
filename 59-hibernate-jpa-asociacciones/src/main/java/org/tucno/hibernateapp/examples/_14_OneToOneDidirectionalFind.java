package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.ClienteDetalle;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _14_OneToOneDidirectionalFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Cliente cliente = entityManager.find(Cliente.class, 1L);
            ClienteDetalle detalle = new ClienteDetalle(true, 100L);
            cliente.addDetalle(detalle);
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
