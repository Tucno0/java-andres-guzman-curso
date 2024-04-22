package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _06_ClausulaMultiselect {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("=========== Consultar de campos personalizados del entity cliente ===========");
        CriteriaQuery<Object[]> criteriaQuery = criteria.createQuery(Object[].class);
        Root<Cliente> from = criteriaQuery.from(Cliente.class);

        // SELECT id, nombre, apellido FROM cliente
        criteriaQuery.multiselect(from.get("id"), from.get("nombre"), from.get("apellido"));

        List<Object[]> resultList = entityManager.createQuery(criteriaQuery).getResultList();
        resultList.forEach(row -> {
            System.out.println("ID: " + row[0] + ", Nombre: " + row[1] + ", Apellido: " + row[2]);
        });


        System.out.println("\n=========== Consultar de campos personalizados del entity cliente con where ===========");
        criteriaQuery = criteria.createQuery(Object[].class);
        from = criteriaQuery.from(Cliente.class);

        // SELECT id, nombre, apellido FROM cliente
        criteriaQuery
                .multiselect(from.get("id"), from.get("nombre"), from.get("apellido"))
                .where(criteria.like(from.get("nombre"), "Jo%"));

        resultList = entityManager.createQuery(criteriaQuery).getResultList();
        resultList.forEach(row -> {
            System.out.println("ID: " + row[0] + ", Nombre: " + row[1] + ", Apellido: " + row[2]);
        });


        System.out.println("\n=========== Consultar de campos personalizados del entity cliente con where id ===========");
        criteriaQuery = criteria.createQuery(Object[].class);
        from = criteriaQuery.from(Cliente.class);

        // SELECT id, nombre, apellido FROM cliente WHERE id = 1
        criteriaQuery
                .multiselect(from.get("id"), from.get("nombre"), from.get("apellido"))
                .where(criteria.equal(from.get("id"), 1));

        Object[] singleResult = entityManager.createQuery(criteriaQuery).getSingleResult();
        System.out.println("ID: " + singleResult[0] + ", Nombre: " + singleResult[1] + ", Apellido: " + singleResult[2]);



        entityManager.close();
    }
}
