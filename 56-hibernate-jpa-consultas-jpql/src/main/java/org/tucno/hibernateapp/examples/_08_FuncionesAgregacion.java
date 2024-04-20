package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _08_FuncionesAgregacion {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        System.out.println("\n============== COUNT => Consultar total de registros ==============");
        Long totalRegistros = entityManager.createQuery("SELECT COUNT(c) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("Total de registros: " + totalRegistros);


        System.out.println("\n============== MIN => Consultar el cliente con el id más bajo ==============");
        Long idMinimo = entityManager.createQuery("SELECT MIN(c.id) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("Id mínimo: " + idMinimo);

        System.out.println("\n============== MAX => Consultar el cliente con el id más alto ==============");
        Long idMaximo = entityManager.createQuery("SELECT MAX(c.id) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("Id máximo: " + idMaximo);

        System.out.println("\n============== SUM => Consultar la suma de los ids de los clientes ==============");
        Long sumaIds = entityManager.createQuery("SELECT SUM(c.id) FROM Cliente c", Long.class).getSingleResult();
        System.out.println("Suma de ids: " + sumaIds);

        System.out.println("\n============== AVG => Consultar el promedio de los ids de los clientes ==============");
        Double promedioIds = entityManager.createQuery("SELECT AVG(c.id) FROM Cliente c", Double.class).getSingleResult();
        System.out.println("Promedio de ids: " + promedioIds);

        System.out.println("\n============== Consultar con nombre y su largo ==============");
        List<Object[]> listaNombresYLongitud = entityManager.createQuery("SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c", Object[].class).getResultList();
        listaNombresYLongitud.forEach((fila) -> {
            System.out.println("Nombre: " + fila[0] + " - Longitud: " + fila[1]);
        });

        System.out.println("\n============== Consultar longitud del nombre más corto ==============");
        Integer longitudMinima = entityManager.createQuery("SELECT MIN(LENGTH(c.nombre)) FROM Cliente c", Integer.class).getSingleResult();
        System.out.println("Longitud mínima: " + longitudMinima);

        System.out.println("\n============== Consultar longitud del nombre más largo ==============");
        Integer longitudMaxima = entityManager.createQuery("SELECT MAX(LENGTH(c.nombre)) FROM Cliente c", Integer.class).getSingleResult();
        System.out.println("Longitud máxima: " + longitudMaxima);

        System.out.println("\n============== Consultar con todas las funciones de agregación ==============");
        Object[] resultado = entityManager.createQuery("SELECT COUNT(c), MIN(c.id), MAX(c.id), SUM(c.id), AVG(c.id), MIN(LENGTH(c.nombre)), MAX(LENGTH(c.nombre)) FROM Cliente c", Object[].class).getSingleResult();
        System.out.println("Total de registros: " + resultado[0]);
        System.out.println("Id mínimo: " + resultado[1]);
        System.out.println("Id máximo: " + resultado[2]);
        System.out.println("Suma de ids: " + resultado[3]);
        System.out.println("Promedio de ids: " + resultado[4]);
        System.out.println("Longitud mínima: " + resultado[5]);
        System.out.println("Longitud máxima: " + resultado[6]);

        entityManager.close();
    }
}
