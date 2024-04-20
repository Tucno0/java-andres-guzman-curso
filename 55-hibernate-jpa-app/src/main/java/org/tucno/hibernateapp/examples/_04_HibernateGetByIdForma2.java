package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class _04_HibernateGetByIdForma2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el id del cliente: ");
        Long id = scanner.nextLong();

        EntityManager entityManager = JpaUtil.getEntityManager();
        Cliente cliente = entityManager.find(Cliente.class, id);

        System.out.println(cliente);
        entityManager.close();
    }
}
