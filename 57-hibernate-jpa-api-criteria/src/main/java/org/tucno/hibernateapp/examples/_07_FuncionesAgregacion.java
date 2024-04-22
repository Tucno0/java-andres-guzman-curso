package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _07_FuncionesAgregacion {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("=========== COUNT => Contar registros ===========");
        CriteriaQuery<Long> queryCount = criteria.createQuery(Long.class);
        Root<Cliente> from = queryCount.from(Cliente.class);

        // SELECT COUNT(*) FROM cliente
        queryCount.select(criteria.count(from));

        Long count = entityManager.createQuery(queryCount).getSingleResult();
        System.out.println("Total de registros: " + count);


        System.out.println("\n=========== SUM => Sumar registros ===========");
        CriteriaQuery<Long> querySum = criteria.createQuery(Long.class);
        from = querySum.from(Cliente.class);

        // SELECT SUM(id) FROM cliente
        querySum.select(criteria.sum(from.get("id")));

        Long sum = entityManager.createQuery(querySum).getSingleResult();
        System.out.println("Suma de los ID: " + sum);


        System.out.println("\n=========== AVG => Promedio de registros ===========");
        CriteriaQuery<Double> queryAvg = criteria.createQuery(Double.class);
        from = queryAvg.from(Cliente.class);

        // SELECT AVG(id) FROM cliente
        queryAvg.select(criteria.avg(from.get("id")));

        Double avg = entityManager.createQuery(queryAvg).getSingleResult();
        System.out.println("Promedio de los ID: " + avg);


        System.out.println("\n=========== MAX => Máximo de registros ===========");
        CriteriaQuery<Long> queryMax = criteria.createQuery(Long.class);
        from = queryMax.from(Cliente.class);

        // SELECT MAX(id) FROM cliente
        queryMax.select(criteria.max(from.get("id")));

        Long max = entityManager.createQuery(queryMax).getSingleResult();
        System.out.println("Máximo de los ID: " + max);


        System.out.println("\n=========== MIN => Mínimo de registros ===========");
        CriteriaQuery<Long> queryMin = criteria.createQuery(Long.class);
        from = queryMin.from(Cliente.class);

        // SELECT MIN(id) FROM cliente
        queryMin.select(criteria.min(from.get("id")));

        Long min = entityManager.createQuery(queryMin).getSingleResult();
        System.out.println("Mínimo de los ID: " + min);

        System.out.println("\n=========== Todos los Funciones de Agregación ===========");
        CriteriaQuery<Object[]> queryAll = criteria.createQuery(Object[].class);
        from = queryAll.from(Cliente.class);

        // SELECT COUNT(*), SUM(id), AVG(id), MAX(id), MIN(id) FROM cliente
        queryAll.multiselect(
                criteria.count(from),
                criteria.sum(from.get("id")),
                criteria.avg(from.get("id")),
                criteria.max(from.get("id")),
                criteria.min(from.get("id"))
        );

        Object[] all = entityManager.createQuery(queryAll).getSingleResult();
        System.out.println("Total de registros: " + all[0]);
        System.out.println("Suma de los ID: " + all[1]);
        System.out.println("Promedio de los ID: " + all[2]);
        System.out.println("Máximo de los ID: " + all[3]);
        System.out.println("Mínimo de los ID: " + all[4]);


        entityManager.close();
    }
}
