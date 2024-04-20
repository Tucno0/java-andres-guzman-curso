package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class _08_HibernateEliminar {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a eliminar"));

        try {
            Cliente cliente = entityManager.find(Cliente.class, id);

            entityManager.getTransaction().begin();
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito " + cliente);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
