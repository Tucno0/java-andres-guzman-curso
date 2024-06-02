package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _03_FetchResoultListOneToManyOneToOne {
    public static void main(String[] args) {
        // Si fetchType es LAZY, no se cargan las colecciones automáticamente
        // Si fetchType es EAGER, se cargan las colecciones automáticamente
        EntityManager entityManager = JpaUtil.getEntityManager();

        List<Cliente> clientes = entityManager.createQuery(
                // cuando se usa fetch se hace un join con la tabla relacionada y se traen los datos de la tabla relacionada
                // Ya no se hace una consulta por cada cliente para traer las direcciones
                "SELECT distinct c FROM Cliente c left outer join fetch c.direcciones left outer join fetch c.detalle",
                Cliente.class
        ).getResultList();
        clientes.forEach(cliente -> {
            System.out.println("Cliente: " + cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        });

        entityManager.close();
    }
}
