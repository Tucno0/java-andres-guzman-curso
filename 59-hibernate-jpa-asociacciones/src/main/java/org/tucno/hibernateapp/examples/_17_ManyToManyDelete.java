package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Alumno;
import org.tucno.hibernateapp.entities.Curso;
import org.tucno.hibernateapp.utils.JpaUtil;

public class _17_ManyToManyDelete {
    public static void main(String[] args) {
        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            entityManager.getTransaction().begin();

            Alumno alumno1 = entityManager.find(Alumno.class, 1L);
            Alumno alumno2 = entityManager.find(Alumno.class, 2L);

            Curso curso1 = new Curso("React", "Miguel");
            Curso curso2 = new Curso("Vue", "Evan");

            alumno1.addCurso(curso1).addCurso(curso2);
            alumno2.addCurso(curso1);

            entityManager.getTransaction().commit();

            System.out.println(alumno1);
            System.out.println(alumno2);

            entityManager.getTransaction().begin();

            Curso curso = entityManager.find(Curso.class, 12L);
            alumno1.getCursos().remove(curso);

            entityManager.getTransaction().commit();

            System.out.println(alumno1);

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
