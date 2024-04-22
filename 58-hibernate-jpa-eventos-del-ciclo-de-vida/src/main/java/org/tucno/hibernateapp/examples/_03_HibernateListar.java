package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import javax.swing.*;
import java.util.List;

public class _03_HibernateListar {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            List<Cliente> clientes = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
            clientes.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        } finally {
            if (entityManager.isOpen()) {
                entityManager.close();
            }
        }
    }
}
