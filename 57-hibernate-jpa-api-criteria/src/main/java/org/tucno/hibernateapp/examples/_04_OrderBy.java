package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _04_OrderBy {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("=========== Consultas con ORDER BY y ASC/DESC ===========");
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);

        // SELECT * FROM cliente ORDER BY nombre ASC, apellido DESC;
        query.select(from).orderBy(criteria.asc(from.get("nombre")), criteria.desc(from.get("apellido")));
        List<Cliente> clientes = entityManager.createQuery(query).getResultList();

        clientes.forEach(System.out::println);


        System.out.println("\n=========== Consultas por id ===========");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);

        // SELECT * FROM cliente WHERE id = 1;
        ParameterExpression<Long> id = criteria.parameter(Long.class, "id");
        query.select(from).where(criteria.equal(from.get("id"), id));

        Cliente cliente = entityManager.createQuery(query)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("\n=========== Consultas solo el nombre de los clientes ===========");
        CriteriaQuery<String> queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        // SELECT nombre FROM cliente;
        queryString.select(from.get("nombre"));
        List<String> nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);


        System.out.println("\n=========== Consultas solo el nombre de los clientes unicos ===========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        // SELECT DISTINCT nombre FROM cliente;
        queryString.select(from.get("nombre")).distinct(true);
        nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("\n=========== Consultas solo el nombre de los clientes unicos (en mayúsculas) ===========");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);

        // SELECT DISTINCT nombre FROM cliente;
        queryString.select(criteria.upper(from.get("nombre"))).distinct(true);
        nombres = entityManager.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        entityManager.close();
    }
}
