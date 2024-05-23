package org.tucno.hibernateapp.examples;

import jakarta.persistence.*;

import org.tucno.hibernateapp.entities.Alumno;
import org.tucno.hibernateapp.entities.Curso;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _15_ManyToManyInsert {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Alumno alumno1 = new Alumno("Juan", "Perez", "juan@gmail.com");
            Alumno alumno2 = new Alumno("Maria", "Gomez", "maria@gmail.com");

            Curso curso1 = new Curso("Java desde cero", "Andréz Guzman");
            Curso curso2 = new Curso("Python desde cero", "Pedro Picapiedra");

            alumno1.addCurso(curso1).addCurso(curso2);
            alumno2.addCurso(curso1);

            entityManager.persist(alumno1);
            entityManager.persist(alumno2);

            entityManager.getTransaction().commit();

            System.out.println(alumno1);
            System.out.println(alumno2);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
