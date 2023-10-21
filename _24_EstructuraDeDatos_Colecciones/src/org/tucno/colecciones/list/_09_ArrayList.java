package org.tucno.colecciones.list;

import org.tucno.colecciones.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class _09_ArrayList {
    public static void main(String[] args) {
        // ARRAYLIST - LISTA
        List<Alumno> al = new ArrayList<>();

        // size() devuelve el número de elementos de la lista
        System.out.println("al.size() = " + al.size());
        // isEmpty() devuelve true si la lista está vacía
        System.out.println("al.isEmpty() = " + al.isEmpty());

        al.add(new Alumno("Juan", 5));
        al.add(new Alumno("Pedro", 6));
        al.add(new Alumno("Alberto", 4));

        // Inserta en la posición 2
        al.add(2,new Alumno("Luci", 4));

        al.add(new Alumno("Andres", 3));
        al.add(new Alumno("Zeus", 2));
        al.add(new Alumno("Zeus", 2));
        al.add(new Alumno("Zeus2", 2));
        al.add(new Alumno("Lucas", 2));

        // con set() se reemplaza el elemento en la posición indicada
        al.set(0, new Alumno("Juan", 7));

        // con remove() se elimina el elemento en la posición indicada
        al.remove(1);
        // con remove() tambien se elimina el elemento indicado (con instancia)
        // Utiliza el método equals() de la clase Alumno para comparar los objetos y eliminar el que coincida
        al.remove(new Alumno("Zeus", 2));

        // contains() devuelve true si el elemento está en la lista
        boolean b = al.contains(new Alumno("Juan", 7));
        System.out.println("La lista contiene a Juan? " + b);

        System.out.println("\nIterando con forEach");
        al.forEach( a -> {
            System.out.println("\t" + al.indexOf(a) + " : " + a);
        });
        System.out.println("\nal.size() = " + al.size());

        // CONVERSIÓN DE LISTA A ARRAY
        Object [] a = al.toArray();

        System.out.println("\nIterando con for");
        for (Object o : a) {
            System.out.println("o = " + o);
        }
    }
}
