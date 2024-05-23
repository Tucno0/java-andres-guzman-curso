package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.ClienteDetalle;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _12_OneToOneInsertFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, 2L); // Buscamos el cliente con id 1
            ClienteDetalle detalle = new ClienteDetalle(true, 1000L);
            entityManager.persist(detalle);
            cliente.setDetalle(detalle); // Asignamos el detalle al cliente
            entityManager.getTransaction().commit(); // commit realiza la transacción en la base de datos

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
