package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _08_BusquedaDinamica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente a buscar: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del cliente a buscar: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la forma de pago del cliente a buscar: ");
        String formaPago = scanner.nextLine();

        EntityManager entityManager = JpaUtil.getEntityManager();
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
        Root<Cliente> from = query.from(Cliente.class);

        List<Predicate> condiciones = new ArrayList<>();
        if (nombre != null && !nombre.isEmpty()) {
            condiciones.add(criteria.like(from.get("nombre"), nombre + "%"));
        }
        if (apellido != null && !apellido.isEmpty()) {
            condiciones.add(criteria.like(from.get("apellido"), apellido + "%"));
        }
        if (formaPago != null && !formaPago.isEmpty()) {
            condiciones.add(criteria.equal(from.get("formaPago"), formaPago));
        }

        // SELECT * FROM cliente WHERE nombre LIKE 'nombre%' AND apellido LIKE 'apellido%' AND forma_pago = 'formaPago'
        query.select(from).where(condiciones.toArray(new Predicate[condiciones.size()]));

        List<Cliente> clientes = entityManager.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        entityManager.close();
    }
}
