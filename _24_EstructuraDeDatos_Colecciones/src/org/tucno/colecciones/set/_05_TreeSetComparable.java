package org.tucno.colecciones.set;

import org.tucno.colecciones.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _05_TreeSetComparable {

    // Para que TreeSet ordene los elementos de manera ascendente, la clase Alumno debe implementar Comparable
    // y sobreescribir el método compareTo() de la interfaz Comparable.
    // En cambio, la clase HashSet no requiere que la clase Alumno implemente Comparable.
    public static void main(String[] args) {
        // Compara por nota
//        Set<Alumno> sa = new TreeSet<>();

        // Compara por nombre ascendente
//        Set<Alumno> sa = new TreeSet<>((a, b) -> a.getNombre().compareTo(b.getNombre()));

        // Compara por nombre descendente
//        Set<Alumno> sa = new TreeSet<>((a, b) -> b.getNombre().compareTo(a.getNombre()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNota));
        sa.add(new Alumno("Juan", 5));
        sa.add(new Alumno("Pedro", 6));
        sa.add(new Alumno("Alberto", 4));
        sa.add(new Alumno("Luci", 4));
        sa.add(new Alumno("Andres", 3));
        sa.add(new Alumno("Zeus", 2));

        // Los TreeSet no permiten elementos duplicados, detectan duplicados por el método compareTo()
        sa.add(new Alumno("Lucas", 2));


        System.out.println("sa = " + sa);
    }
}
