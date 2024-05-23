package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.Factura;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _01_ManyToOneInsert {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            // Se inicia una transacción
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Pérez"); // Se crea un nuevo cliente
            cliente.setFormaPago("Tarjeta");
            entityManager.persist(cliente); // Se guarda el cliente en la base de datos

            Factura factura1 = new Factura("Compras de Oficina", 1000L); // Se crea una nueva factura
            factura1.setCliente(cliente); // Se asigna el cliente a la factura
            entityManager.persist(factura1); // Se guarda la factura en la base de datos

            System.out.println(factura1);
            System.out.println(factura1.getCliente());

            // Se confirma la transacción
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
