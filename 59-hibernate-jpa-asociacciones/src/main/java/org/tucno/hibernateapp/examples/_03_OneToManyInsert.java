package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.Direccion;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _03_OneToManyInsert {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente("Juan", "Pérez");
            cliente.setFormaPago("Yape");

            Direccion direccion1 = new Direccion("Av. Javier Prado", 123);
            Direccion direccion2 = new Direccion("Av. Arequipa", 456);

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);

            entityManager.persist(cliente);

            System.out.println(cliente);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
