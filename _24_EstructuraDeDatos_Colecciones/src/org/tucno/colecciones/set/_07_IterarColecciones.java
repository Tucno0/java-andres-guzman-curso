package org.tucno.colecciones.set;

import org.tucno.colecciones.modelo.Alumno;

import java.util.*;

public class _07_IterarColecciones {
    public static void main(String[] args) {
        System.out.println("TRABAJANDO CON HASHSET");
        Set<Alumno> sa = new HashSet<>();

        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Pedro", 6));
        sa.add(new Alumno("Alberto", 4));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus2", 2));
        sa.add(new Alumno("Lucas", 2));
        sa.add(new Alumno("Lucas", 3));

        System.out.println("sa = " + sa);

        // Formas loop o iteraciones en los Collections Set y List
        // 1. For each
        System.out.println("\nIterando con for each");
        for (Alumno a : sa) {
            System.out.println("\ta = " + a);
        }

        // 2. Iterador
        System.out.println("\nIterando con iterador y while");
        Iterator<Alumno> it = sa.iterator(); // Se crea el iterador para el conjunto sa

        while (it.hasNext()) { // Mientras exista un siguiente elemento
            Alumno a = it.next(); // Se obtiene el siguiente elemento
            System.out.println("\ta = " + a);
        }

        System.out.println("\n\nTRABAJANDO CON TREESET");
        Set<Alumno> treeSetAlumno = new TreeSet<>(  );

        treeSetAlumno.add(new Alumno("Juan", 5));
        treeSetAlumno.add(new Alumno("Pedro", 6));
        treeSetAlumno.add(new Alumno("Alberto", 4));
        treeSetAlumno.add(new Alumno("Luci", 4));
        treeSetAlumno.add(new Alumno("Andres", 3));
        treeSetAlumno.add(new Alumno("Zeus", 2));
        treeSetAlumno.add(new Alumno("Zeus", 2));
        treeSetAlumno.add(new Alumno("Zeus2", 2));
        treeSetAlumno.add(new Alumno("Lucas", 2));
        treeSetAlumno.add(new Alumno("Lucas", 3));

        System.out.println("\ntreeSetAlumno = " + treeSetAlumno);

        // Formas loop o iteraciones en los Collections Set y List
        // 1. For each
        System.out.println("\nIterando con for each");
        for (Alumno a : treeSetAlumno) {
            System.out.println("\ta = " + a);
        }

        // 2. Iterador
        System.out.println("\nIterando con iterador y while");
        Iterator<Alumno> it2 = treeSetAlumno.iterator();

        while (it2.hasNext()) {
            Alumno a = it2.next();
            System.out.println("\ta = " + a);
        }

        // 3. For each con lambda
        System.out.println("\nIterando con for each con lambda");
        // Forma corta
        // treeSetAlumno.forEach( System.out::println );
        treeSetAlumno.forEach( alumno -> {
            System.out.println("\talumno = " + alumno);
        } );

        System.out.println("\n\nTRABAJANDO CON ARRAYLIST DE LIST");
        List<Alumno> arrayListAlumnos = new ArrayList<>();

        arrayListAlumnos.add(new Alumno("Juan", 5));
        arrayListAlumnos.add(new Alumno("Pedro", 6));
        arrayListAlumnos.add(new Alumno("Alberto", 4));
        arrayListAlumnos.add(new Alumno("Luci", 4));
        arrayListAlumnos.add(new Alumno("Andres", 3));
        arrayListAlumnos.add(new Alumno("Zeus", 2));
        arrayListAlumnos.add(new Alumno("Zeus", 2));
        arrayListAlumnos.add(new Alumno("Zeus2", 2));
        arrayListAlumnos.add(new Alumno("Lucas", 2));
        arrayListAlumnos.add(new Alumno("Lucas", 3));

        System.out.println("\narrayListAlumnos = " + arrayListAlumnos);

        // Formas loop o iteraciones en los Collections Set y List
        // 1. For each
        System.out.println("\nIterando con for each");
        for (Alumno a : arrayListAlumnos) {
            System.out.println("\ta = " + a);
        }

        // 2. Iterador
        System.out.println("\nIterando con iterador y while");
        Iterator<Alumno> it3 = arrayListAlumnos.iterator();

        while (it3.hasNext()) {
            Alumno a = it3.next();
            System.out.println("\ta = " + a);
        }

        // 3. For each con lambda
        System.out.println("\nIterando con for each con lambda");
        // Forma corta
        // arrayListAlumnos.forEach( System.out::println );
        arrayListAlumnos.forEach( alumno -> {
            System.out.println("\talumno = " + alumno);
        } );

        // 4. Usan un for clásico
        System.out.println("\nIterando con for clásico");
        for (int i = 0; i < arrayListAlumnos.size(); i++) {
            // Se obtiene el elemento en la posición i, los ArrayList tienen índices
            System.out.println("\tarrayListAlumnos.get(i) = " + arrayListAlumnos.get(i));
        }

    }
}
