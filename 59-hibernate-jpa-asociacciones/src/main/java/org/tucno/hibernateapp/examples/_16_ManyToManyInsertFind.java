package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Alumno;
import org.tucno.hibernateapp.entities.Curso;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _16_ManyToManyInsertFind {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Alumno alumno1 = entityManager.find(Alumno.class, 1L);
            Alumno alumno2 = entityManager.find(Alumno.class, 2L);

            Curso curso1 = entityManager.find(Curso.class, 1L);
            Curso curso2 = entityManager.find(Curso.class, 2L);

            alumno1.addCurso(curso1).addCurso(curso2);
            alumno2.addCurso(curso1);

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
