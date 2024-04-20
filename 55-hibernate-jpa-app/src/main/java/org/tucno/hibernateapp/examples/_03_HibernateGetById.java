package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.tucno.hibernateapp.entity.Cliente;
import org.tucno.hibernateapp.util.JpaUtil;

import java.util.Scanner;

public class _03_HibernateGetById {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EntityManager entityManager = JpaUtil.getEntityManager();

        Query query = entityManager.createQuery("SELECT c FROM Cliente c WHERE c.id = ?1", Cliente.class);

        System.out.print("Introduce el id del cliente: ");
        Long id = scanner.nextLong();
        query.setParameter(1, id);

        // Se obtiene un único resultado con getSingleResult
        // Si se quiere obtener varios resultados se puede usar getResultList
        Cliente cliente = (Cliente) query.getSingleResult();
        System.out.println(cliente);

        // JPA guarda en caché los objetos que se han recuperado de la base de datos, por lo que si se vuelve a recuperar el mismo objeto, se obtendrá el mismo objeto de la caché
        Cliente cliente2 = entityManager.find(Cliente.class, id);
        System.out.println(cliente2);

        entityManager.close();
    }
}
