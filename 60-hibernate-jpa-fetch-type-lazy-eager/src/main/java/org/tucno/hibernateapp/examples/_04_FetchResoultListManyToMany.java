package org.tucno.hibernateapp.examples;

import jakarta.persistence.EntityManager;
import org.tucno.hibernateapp.entities.Alumno;
import org.tucno.hibernateapp.entities.Cliente;
import org.tucno.hibernateapp.utils.JpaUtil;

import java.util.List;

public class _04_FetchResoultListManyToMany {
    public static void main(String[] args) {
        // Si fetchType es LAZY, no se cargan las colecciones automáticamente
        // Si fetchType es EAGER, se cargan las colecciones automáticamente
        EntityManager entityManager = JpaUtil.getEntityManager();

        List<Alumno> alumnos = entityManager.createQuery(
                "SELECT DISTINCT a FROM Alumno a LEFT OUTER JOIN FETCH a.cursos",
                Alumno.class
        ).getResultList();

        alumnos.forEach(cliente -> {
            System.out.println("====> Alumno: " + cliente.getNombre() + ", cursos: " + cliente.getCursos());
        });

        entityManager.close();
    }
}
