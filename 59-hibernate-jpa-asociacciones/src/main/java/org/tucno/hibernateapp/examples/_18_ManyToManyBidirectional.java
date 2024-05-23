package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Alumno;
import org.tucno.hibernateapp.entities.Curso;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _18_ManyToManyBidirectional {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Alumno alumno1 = new Alumno("Juan", "Perez", "juan@gmail.com");
            Alumno alumno2 = new Alumno("Maria", "Gomez", "maria@gmail.com");

            Curso curso1 = new Curso("React", "Miguel");
            Curso curso2 = new Curso("Vue", "Evan");

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
