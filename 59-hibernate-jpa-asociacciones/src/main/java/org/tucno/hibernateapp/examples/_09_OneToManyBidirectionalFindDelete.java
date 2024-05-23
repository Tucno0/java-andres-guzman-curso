package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.Factura;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _09_OneToManyBidirectionalFindDelete {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();
            Cliente cliente = entityManager.find(Cliente.class, 1L);
            Factura factura1 = new Factura("Compras de Supermercado", 2000L);
            Factura factura2 = new Factura("Compras de Tecnología", 3000L);
            cliente.addFactura(factura1).addFactura(factura2);

            entityManager.merge(cliente);
            entityManager.getTransaction().commit();

            System.out.println(cliente);

            entityManager.getTransaction().begin();
            Factura factura = entityManager.find(Factura.class, 1L);
            cliente.getFacturas().remove(factura); // Eliminamos la factura de la lista de facturas del cliente
            factura.setCliente(null); // Eliminamos la relación entre la factura y el cliente
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
