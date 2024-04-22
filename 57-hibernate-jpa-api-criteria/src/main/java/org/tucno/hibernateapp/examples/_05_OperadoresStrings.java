package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _05_OperadoresStrings {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("=========== Consultar nombres y apellidos concatenados ===========");
        CriteriaQuery<String> queryString = criteria.createQuery(String.class);
        Root<Cliente> from = queryString.from(Cliente.class);

        // SELECT CONCAT(nombre, ' ', apellido) FROM Cliente
        queryString.select(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido")));

        List<String> nombresCompletos = entityManager.createQuery(queryString).getResultList();
        nombresCompletos.forEach(System.out::println);


        System.out.println("\n=========== Consultar nombres y apellidos concatenados en mayúsculas ===========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        // SELECT UPPER(CONCAT(nombre, ' ', apellido)) FROM Cliente
        queryString.select(criteria.upper(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido"))));

        nombresCompletos = entityManager.createQuery(queryString).getResultList();
        nombresCompletos.forEach(System.out::println);


        entityManager.close();
    }
}
