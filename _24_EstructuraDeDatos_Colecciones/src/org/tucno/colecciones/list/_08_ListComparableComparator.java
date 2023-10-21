package org.tucno.colecciones.list;

import org.tucno.colecciones.modelo.Alumno;

import java.util.*;

public class _08_ListComparableComparator {
    public static void main(String[] args) {

//        List<Alumno> la = new ArrayList<>();
        List<Alumno> la = new LinkedList<>();
        la.add(new Alumno("Juan", 5));
        la.add(new Alumno("Pedro", 6));
        la.add(new Alumno("Alberto", 4));
        la.add(new Alumno("Luci", 4));
        la.add(new Alumno("Andres", 3));
        la.add(new Alumno("Zeus", 2));
        la.add(new Alumno("Zeus", 2));
        la.add(new Alumno("Zeus2", 2));
        la.add(new Alumno("Lucas", 2));
        la.add(new Alumno("Lucas", 3));

        la.forEach(System.out::println);

        // Ordenar la lista con el método sort de la clase Collections
        // Ordena por nota ascendente, sobreescribiendo el método compareTo de la clase Alumno
//        Collections.sort(la, (a, b) -> a.getNota().compareTo(b.getNota()));

        // Otras formas de ordenar
//        Collections.sort(la, Comparator.comparing(Alumno::getNota));
//        la.sort((a, b) -> a.getNota().compareTo(b.getNota()));
//        la.sort(Comparator.comparing( (Alumno a) -> a.getNota())); // ordena por nota ascendente
//        la.sort(Comparator.comparing( (Alumno a) -> a.getNombre())); // ordena por nombre ascendente
//        la.sort(Comparator.comparing( (Alumno a) -> a.getNombre()).reversed()); // ordena por nombre descendente, reverse() invierte el orden
        la.sort(Comparator.comparing (Alumno::getNombre).reversed()); // mas corto

        System.out.println("\nLista ordenada con Comparable");
        la.forEach(System.out::println);
    }
}
