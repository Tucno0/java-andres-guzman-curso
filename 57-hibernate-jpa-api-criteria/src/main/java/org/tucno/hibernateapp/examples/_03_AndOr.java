package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _03_AndOr {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("=========== Conjunction (AND) y Disjunction (OR) ===========");
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);

        Predicate porNombre = criteria.equal(from.get("nombre"), "John");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"), "Credito");
        Predicate mayorA = criteria.ge(from.get("id"), 2L);

        // SELECT * FROM cliente WHERE id >= 2 AND (nombre = 'John' OR formaPago = 'Credito');
        query.select(from).where(criteria.and(mayorA, criteria.or(porNombre, porFormaPago)));
        List<Cliente> clientes = entityManager.createQuery(query).getResultList();

        clientes.forEach(System.out::println);

        entityManager.close();
    }
}
