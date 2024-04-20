package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _09_GroupBy {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Consultar cantidad de clientes por forma de pago ==============");
        List<Object[]> cantidadClientesPorFormaPago = entityManager.createQuery("SELECT c.formaPago, COUNT(c) FROM Cliente c GROUP BY c.formaPago", Object[].class).getResultList();
        cantidadClientesPorFormaPago.forEach((fila) -> {
            System.out.println("Forma de pago: " + fila[0] + " - Cantidad de clientes: " + fila[1]);
        });

        System.out.println("\n============== Consultar cuantos clientes tienen cada nombre ==============");
        List<Object[]> cantidadClientesPorNombre = entityManager.createQuery("SELECT c.nombre, COUNT(c) FROM Cliente c GROUP BY c.nombre", Object[].class).getResultList();
        cantidadClientesPorNombre.forEach((fila) -> {
            System.out.println("Nombre: " + fila[0] + " - Cantidad de clientes: " + fila[1]);
        });

        entityManager.close();
    }
}
