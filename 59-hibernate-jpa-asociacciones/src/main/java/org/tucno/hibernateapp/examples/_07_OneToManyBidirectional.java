package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.Factura;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _07_OneToManyBidirectional {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Cliente cliente = new Cliente("Juan", "Pérez");
            cliente.setFormaPago("Tarjeta");

            Factura factura1 = new Factura("Compras de Oficina", 1000L);
            Factura factura2 = new Factura("Compras de Escritorio", 2000L);
            Factura factura3 = new Factura("Compras de Computadoras", 3000L);

            // Como es bidireccional, se deben relacionar en ambas direcciones
//            cliente.getFacturas().add(factura1);
//            cliente.getFacturas().add(factura2);
//            cliente.getFacturas().add(factura3);
//            factura1.setCliente(cliente);
//            factura2.setCliente(cliente);
//            factura3.setCliente(cliente);

            // Se puede simplificar con el método addFactura de la clase Cliente
            cliente.addFactura(factura1).addFactura(factura2).addFactura(factura3);

            // Solo se guarda el cliente, las facturas se guardan automáticamente
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
