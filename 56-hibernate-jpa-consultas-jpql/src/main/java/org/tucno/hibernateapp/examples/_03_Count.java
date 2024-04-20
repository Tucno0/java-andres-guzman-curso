package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _03_Count {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== Consultar cantidad de formasPago únicas ==============");
        Long cantidadFormasPago = entityManager.createQuery("SELECT COUNT(DISTINCT c.formaPago) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("Cantidad de formas de pago únicas: " + cantidadFormasPago);

        entityManager.close();
    }
}
