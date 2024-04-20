package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class _02_HibernateSingleResultWhere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = JpaUtil.getEntityManager();

        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.formaPago = ?1", Cliente.class);

        System.out.print("Introduce la forma de pago: ");
        String formaPago = scanner.nextLine();
        query.setParameter(1, formaPago);
        query.setMaxResults(1); // Limita el número de resultados a 1 (opcional para evitar excepciones)

        // Se obtiene un único resultado con getSingleResult
        // Si se quiere obtener varios resultados se puede usar getResultList
        Cliente cliente = (Cliente) query.getSingleResult();

        System.out.println(cliente);

        entityManager.close();
    }
}
