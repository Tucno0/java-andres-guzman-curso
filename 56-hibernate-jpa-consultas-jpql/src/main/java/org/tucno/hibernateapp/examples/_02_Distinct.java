package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _02_Distinct {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("============== Consultar clientes sin repetir ==============");
        List<String> nombres = entityManager.createQuery("SELECT DISTINCT c.nombre FROM Cliente c", String.class).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("\n============== Consultar formaPago sin repetir ==============");
        List<String> formasPago = entityManager.createQuery("SELECT DISTINCT c.formaPago FROM Cliente c", String.class).getResultList();
        formasPago.forEach(System.out::println);

        entityManager.close();
    }
}
