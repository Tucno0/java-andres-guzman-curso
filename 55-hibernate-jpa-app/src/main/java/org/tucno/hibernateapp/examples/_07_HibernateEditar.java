package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class _07_HibernateEditar {
    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a editar"));
            Cliente cliente = entityManager.find(Cliente.class, id);

            if (cliente == null) {
                JOptionPane.showMessageDialog(null, "No se encontró el cliente con id " + id);
                return;
            }

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre", cliente.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido", cliente.getApellido());
            String formaPago = JOptionPane.showInputDialog("Ingrese la forma de pago", cliente.getFormaPago());

            entityManager.getTransaction().begin();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            entityManager.merge(cliente); // merge() actualiza el objeto en la base de datos
            entityManager.getTransaction().commit();

            System.out.println("Cliente editado con éxito: " + cliente);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
