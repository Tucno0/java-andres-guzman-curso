package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _04_OperadoresStrings {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== CONCAT => Consultar nombre y apellido concatenados ==============");
        List<String> nombresCompletos = entityManager.createQuery("SELECT CONCAT(c.nombre, ' ', c.apellido) AS nombreCompleto FROM Cliente c", String.class).getResultList();
        nombresCompletos.forEach(System.out::println);

         System.out.println("\n============== Consultar nombre y apellido concatenados - Forma 2 ==============");
        nombresCompletos = entityManager.createQuery("SELECT c.nombre || ' ' || c.apellido AS nombreCompleto FROM Cliente c", String.class).getResultList();
        nombresCompletos.forEach(System.out::println);

        System.out.println("\n============== UPPER => Consultar nombre y apellido en mayúsculas ==============");
        List<String> nombresMayusculas = entityManager.createQuery("SELECT UPPER(CONCAT(c.nombre, ' ', c.apellido)) AS nombreCompleto FROM Cliente c", String.class)                                            .getResultList();
        nombresMayusculas.forEach(System.out::println);

        System.out.println("\n============== LOWER => Consultar nombre y apellido en minúsculas ==============");
        List<String> nombresMinusculas = entityManager.createQuery("SELECT LOWER(CONCAT(c.nombre, ' ', c.apellido)) AS nombreCompleto FROM Cliente c", String.class)                                            .getResultList();
        nombresMinusculas.forEach(System.out::println);

        System.out.println("\n============== LENGTH => Consultar la longitud del nombre ==============");
        List<Integer> longitudes = entityManager.createQuery("SELECT LENGTH(c.nombre) FROM Cliente c", Integer.class).getResultList();
        longitudes.forEach(System.out::println);

        entityManager.close();
    }
}
