package org.tucno.colecciones.set;

import org.tucno.colecciones.modelo.Alumno;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _06_HashSetUnicidad {

    public static void main(String[] args) {
        // Los HashSet no permiten elementos duplicados, pero si contienen diferentes objetos con los mismos valores de atributos.
        // Para determinar si un elemento es duplicado, se utiliza el método equals() de la clase Object.
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
    }
}
