package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import javax.swing.*;
import java.util.List;

public class _01_HibernateCrear {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago del cliente");

            entityManager.getTransaction().begin();

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);

            entityManager.persist(cliente); // Guarda el objeto en la base de datos
            entityManager.getTransaction().commit(); // Confirma la transacción

            JOptionPane.showMessageDialog(null, "Cliente guardado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(cliente);

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
