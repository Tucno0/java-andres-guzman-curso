package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.Arrays;
import java.util.List;

public class _02_LikeBetween {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("===================== Usando WHERE y LIKE para buscar clientes por nombre =====================");
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);
        ParameterExpression<String> nombreParamLike = criteria.parameter(String.class, "nombreParam");
        // SELECT * FROM Cliente WHERE nombre LIKE '%jo%'
        query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParamLike)));
        List<Cliente> clientes = entityManager.createQuery(query).setParameter("nombreParam", "%jo%").getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===================== Usando WHERE y BETWEEN para rangos =====================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        // SELECT * FROM Cliente WHERE id BETWEEN 2 AND 6
        query.select(from).where(criteria.between(from.get("id"), 2L, 6L));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===================== Usando WHERE IN =====================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        // SELECT * FROM Cliente WHERE id IN (2, 4, 6)
        query.select(from).where(from.get("id").in(2L, 4L, 6L));
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===================== Usando WHERE IN usando param =====================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<List> listParam = criteria.parameter(List.class, "nombres");
        // SELECT * FROM Cliente WHERE nombre IN ('John', 'Lou')
        query.select(from).where(from.get("nombre").in(listParam));
        clientes = entityManager.createQuery(query)
                .setParameter("nombres", Arrays.asList("John", "Lou"))
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===================== Filtrar usando predicados mayor que =====================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        // SELECT * FROM Cliente WHERE id >= 3
        query.select(from).where(criteria.ge(from.get("id"), 3L)); // id >= 3
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("\n===================== Filtrar clientes cuyo longitudes de nombre sea mayor que 4 =====================");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        // SELECT * FROM Cliente WHERE length(nombre) > 4
        query.select(from).where(criteria.gt(criteria.length(from.get("nombre")), 4L)); // length(nombre) > 4
        clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        entityManager.close();
    }
}
