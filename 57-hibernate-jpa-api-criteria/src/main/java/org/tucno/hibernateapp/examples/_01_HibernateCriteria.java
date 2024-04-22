package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _01_HibernateCriteria {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        // La API Criteria de JPA permite construir consultas de manera programática y orientada a objetos
        // en lugar de escribir consultas en lenguaje JPQL.
        // Usa el patrón de diseño Builder para construir consultas de manera más sencilla y segura.
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();

        System.out.println("==================== Consulta de todos los clientes ====================");
        // Se crea un objeto CriteriaQuery que representa la consulta que se desea realizar.
        CriteriaQuery<Cliente> criteriaQuery = criteria.createQuery(Cliente.class);

        // Se crea un objeto Root que representa la entidad principal de la consulta.
        Root<Cliente> root = criteriaQuery.from(Cliente.class);

        // Se construye la consulta
        criteriaQuery.select(root); // SELECT * FROM Cliente
        List<Cliente> clientes = entityManager.createQuery(criteriaQuery).getResultList();

        // Se recorren los resultados
        clientes.forEach(System.out::println);

        System.out.println("\n==================== Consulta de clientes con where ====================");
        criteriaQuery = criteria.createQuery(Cliente.class); // Se vuelve a crear el objeto CriteriaQuery
        root = criteriaQuery.from(Cliente.class); // Se vuelve a crear el objeto Root
        ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre"); // Se crea un parámetro
        criteriaQuery.select(root).where(criteria.equal(root.get("nombre"), nombreParam)); // SELECT * FROM Cliente WHERE nombre = 'Juan'
        clientes = entityManager.createQuery(criteriaQuery).setParameter("nombre", "john").getResultList(); // Se ejecuta la consulta
        clientes.forEach(System.out::println);


        entityManager.close();
    }
}
