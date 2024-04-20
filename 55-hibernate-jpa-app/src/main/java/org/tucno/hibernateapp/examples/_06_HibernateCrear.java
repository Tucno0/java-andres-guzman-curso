package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import javax.swing.*;

public class _06_HibernateCrear {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin(); // begin() inicia la transacción

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
            String formaPago = JOptionPane.showInputDialog("Ingrese la forma de pago");

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            entityManager.persist(cliente); // persist() guarda el objeto en la base de datos
            entityManager.getTransaction().commit(); // commit() guarda los cambios en la base de datos

            System.out.println("Cliente creado con éxito: " + cliente);

            cliente = entityManager.find(Cliente.class, cliente.getId());

            System.out.println("Cliente recuperado de la base de datos: " + cliente);
        } catch ( Exception e ) {
            entityManager.getTransaction().rollback(); // rollback() deshace los cambios en la base de datos
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
