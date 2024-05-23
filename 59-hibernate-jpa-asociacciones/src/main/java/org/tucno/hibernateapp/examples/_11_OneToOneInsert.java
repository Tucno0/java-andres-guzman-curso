package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.ClienteDetalle;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _11_OneToOneInsert {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Perez");
            cliente.setFormaPago("Tarjeta de Crédito");
            entityManager.persist(cliente);

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
