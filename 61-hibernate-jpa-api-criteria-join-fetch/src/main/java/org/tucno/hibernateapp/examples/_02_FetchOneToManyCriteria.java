package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _02_FetchOneToManyCriteria {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
        Root<Cliente> root = criteriaQuery.from(Cliente.class);

        // fetch se utiliza para traer la relacion de uno a muchos (OneToMany)
        root.fetch("direcciones", JoinType.LEFT);
        root.fetch("detalle", JoinType.LEFT);
        criteriaQuery.select(root).distinct(true);

        List<Cliente> clientes = entityManager.createQuery(criteriaQuery).getResultList();
        clientes.forEach(cliente -> {
            System.out.println(cliente.getNombre());
            System.out.println("direcciones = " + cliente.getDirecciones());
            System.out.println("detalle = " + cliente.getDetalle());
            System.out.println();
        });

        entityManager.close();
    }
}
