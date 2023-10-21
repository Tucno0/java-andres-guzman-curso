package org.tucno.colecciones.set;

import java.util.HashSet;
import java.util.Set;

public class _01_HashSetAgregar {
    public static void main(String[] args) {
        // HashSet
        // Implementa la interfaz Set y la interfaz Collection (que a su vez extiende la interfaz Iterable)
        // No es ordenado ni mantiene un orden de inserción
        // Si se agregan elementos duplicados, no se agregan de nuevo
        // Los metodos de la interfaz Collection son heredados por HashSet
        // Son las siguientes:
        // add(), addAll(), clear(), contains(), containsAll(), equals(), hashCode(), isEmpty(), iterator(), remove(),
        // removeAll(), removeIf(), retainAll(), size(), spliterator(), toArray(), toArray(T[] a)

        Set<String> hs = new HashSet<>();

        // Add(): agrega un elemento al conjunto, retorna true si el elemento no estaba en el conjunto
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");

        System.out.println(hs);

        // Agregar un elemento duplicado
        boolean agregado = hs.add("uno");
        System.out.println("Permitió agregar un elemento duplicado?: " + agregado);
        System.out.println(hs);
    }
}
