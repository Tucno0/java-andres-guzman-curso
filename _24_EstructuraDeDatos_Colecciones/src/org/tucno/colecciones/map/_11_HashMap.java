package org.tucno.colecciones.map;

import java.util.HashMap;
import java.util.Map;

public class _11_HashMap {
    public static void main(String[] args) {
        // HASHMAP
        // Implementa la interfaz Map y la interfaz Cloneable
        // Almacena los datos en una tabla hash (array de listas enlazadas)
        // No permite claves duplicadas, si se añade un elemento con una clave que ya existe, se reemplaza el valor
        // Permite valores null
        // No es sincronizado (no es thread-safe)
        // Sirve para almacenar grandes cantidades de datos sin tener que recorrerlos (búsqueda rápida)
        // No garantiza el orden de los elementos
        // Utiliza el método equals() para comparar las claves y el método hashCode() para calcular el índice de la tabla hash

        Map<String, String> persona = new HashMap<>();

        // put() añade un elemento a la tabla hash
        persona.put(null, "1234"); // se puede añadir una clave null
        persona.put(null, "12345"); // si se añade una clave null, se reemplaza el valor
        persona.put("nombre", "Juan");
        persona.put("nombre2", "Juan"); // se puede añadir un valor que ya existe
        persona.put("apellido", "Pere");
        persona.put("apellido", "Perez"); // si se añade una clave que ya existe, se reemplaza el valor
        persona.put("email", "juan@gmail.com");
        persona.put("edad", "30");

        // size() devuelve el número de elementos de la tabla hash
        System.out.println("persona.size() = " + persona.size());

        // imprimir la tabla hash
        System.out.println("\nImprimir la tabla hash");
        System.out.println("persona = " + persona);

        // get() devuelve el valor de la clave indicada
        System.out.println("\npersona.get(\"nombre\") = " + persona.get("nombre"));
        System.out.println("persona.get(\"apellido\") = " + persona.get("apellido"));

        System.out.println("\nIterando con for");
        for (String key : persona.keySet()) {
            System.out.println("\tkey = " + key + ", value = " + persona.get(key));
        }
    }
}
