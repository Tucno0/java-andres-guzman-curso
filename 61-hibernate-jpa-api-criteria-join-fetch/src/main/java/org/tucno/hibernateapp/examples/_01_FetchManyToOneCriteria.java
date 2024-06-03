package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.entities.Factura;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _01_FetchManyToOneCriteria {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Factura> criteriaQuery = criteriaBuilder.createQuery(Factura.class);
        Root<Factura> root = criteriaQuery.from(Factura.class);

        // el metodo fetch se utiliza para traer la relacion de muchos a uno
        // Por defecto es inner join
        Fetch<Factura, Cliente> cliente = root.fetch("cliente", JoinType.LEFT);
//        Join<Factura, Cliente> cliente = (Join) root.fetch("cliente", JoinType.LEFT);

        cliente.fetch("detalle", JoinType.LEFT);

        criteriaQuery.select(root);

        List<Factura> facturas = entityManager.createQuery(criteriaQuery).getResultList();
        facturas.forEach(factura -> {
            System.out.println(factura.getDescripcion());
            System.out.println(factura.getCliente().getNombre() + "\n");
        });

        entityManager.close();
    }
}
