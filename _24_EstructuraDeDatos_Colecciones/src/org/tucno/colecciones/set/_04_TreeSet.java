package org.tucno.colecciones.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class _04_TreeSet {
    public static void main(String[] args) {
        // TreeSet
        // Ordena los elementos por defecto de manera ascendente y automáticamente elimina los duplicados.
        // Es una implementación de Set que mantiene los elementos ordenados de acuerdo a un criterio definido por el usuario.
        // Almacena los elementos en un árbol binario de búsqueda.
        // Tiene un rendimiento menor que HashSet y LinkedHashSet.
        // Los elementos deben implementar la interfaz Comparable o se debe pasar un objeto Comparator al constructor del TreeSet.

        // Ejemplo de TreeSet con String
//        Set<String> ts = new TreeSet<>(); // Ordena de manera ascendente
//        Set<String> ts = new TreeSet<>( (a, b) -> b.compareTo(a) ); // Ordena de manera descendente
        Set<String> ts = new TreeSet<>(Comparator.reverseOrder()); // Ordena de manera descendente
        ts.add("Uno");
        ts.add("Dos");
        ts.add("Tres");
        ts.add("Tres"); // Todos los Set no permiten elementos duplicados
        ts.add("Cuatro");
        ts.add("Cinco");
        System.out.println("ts = " + ts);

        // Ejemplo de TreeSet con Integer
        Set<Integer> numeros = new TreeSet<>((a, b) -> b.compareTo(a)); // Ordena de manera descendente
        numeros.add(1);
        numeros.add(5);
        numeros.add(3);
        numeros.add(4);
        numeros.add(10);
        numeros.add(3);
        numeros.add(2);
        System.out.println("numeros = " + numeros);
    }
}
