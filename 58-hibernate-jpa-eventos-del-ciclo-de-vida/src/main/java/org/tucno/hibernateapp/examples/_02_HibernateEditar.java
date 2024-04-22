package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import javax.swing.*;
import java.util.List;

public class _02_HibernateEditar {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            Long id = Long.parseLong(JOptionPane.showInputDialog("Ingrese el ID del cliente a editar"));
            Cliente cliente = entityManager.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente", cliente.getNombre());
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente", cliente.getApellido());
            String pago = JOptionPane.showInputDialog("Ingrese la forma de pago del cliente", cliente.getFormaPago());

            entityManager.getTransaction().begin();

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(pago);

            entityManager.merge(cliente); // Actualiza el objeto en la base de datos
            entityManager.getTransaction().commit(); // Confirma la transacción

            JOptionPane.showMessageDialog(null, "Cliente guardado con éxito");

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
