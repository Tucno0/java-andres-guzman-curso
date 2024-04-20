package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.List;
import java.util.Scanner;

public class _05_HibernateResultListWhere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = JpaUtil.getEntityManager();

        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.formaPago = ?1", Cliente.class);

        System.out.print("Introduce la forma de pago: ");
        String formaPago = scanner.nextLine();
        query.setParameter(1, formaPago);

        // Se obtiene un único resultado con getSingleResult
        // Si se quiere obtener varios resultados se puede usar getResultList
        List<Cliente> cliente = query.getResultList();

        cliente.forEach(System.out::println);

        entityManager.close();
    }
}
