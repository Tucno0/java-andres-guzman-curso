package org.tucno.colecciones.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _12_HashMapMetodos {
    public static void main(String[] args) {
        Map<String, String> persona = new HashMap<>();

        persona.put(null, "1234"); // se puede añadir una clave null
        persona.put(null, "12345"); // si se añade una clave null, se reemplaza el valor
        persona.put("nombre", "Juan");
        persona.put("nombre2", "Juan"); // se puede añadir un valor que ya existe
        persona.put("apellido", "Pere");
        persona.put("apellido", "Perez"); // si se añade una clave que ya existe, se reemplaza el valor
        persona.put("email", "juan@gmail.com");
        persona.put("edad", "30");

        // clear() elimina todos los elementos de la tabla hash
//        persona.clear();

        System.out.println("\nIterando con for");
        for (String key : persona.keySet()) {
            System.out.println("\tkey = " + key + ", value = " + persona.get(key));
        }

        // remove() elimina el elemento de la tabla hash que tenga la clave indicada, devuelve el valor del elemento eliminado
        String valorEliminado = persona.remove("nombre2");
        System.out.println("\nvalorEliminado = " + valorEliminado);
        boolean eliminado = persona.remove("nombre2", "Juan"); // elimina el elemento si la clave y el valor coinciden
        System.out.println("eliminado = " + eliminado);

        // containsKey() devuelve true si la tabla hash contiene la clave indicada
        boolean b2 = persona.containsKey("nombre");
        System.out.println("\nb2 = " + b2);

        // containsValue() devuelve true si la tabla hash contiene el valor indicado
        b2 = persona.containsValue("Juan");
        System.out.println("b2 = " + b2);

        // Collection<V> values() devuelve una colección con los valores de la tabla hash
        Collection<String> valores = persona.values();
        System.out.println("\nvalores = " + valores);

        Set<String> claves = persona.keySet();
        System.out.println("claves = " + claves);

        //Imprimir la tabla hash
        System.out.println("\nImprimir con keySet()");
        Set<String> llaves = persona.keySet();
        for (String key : llaves) {
            System.out.println("\tkey = " + key + ", value = " + persona.get(key));
        }

        System.out.println("\nImprimir con entrySet()");
        for (Map.Entry<String, String> entry : persona.entrySet()) {
            System.out.println("\tkey = " + entry.getKey() + ", value = " + entry.getValue());
        }

        // size() devuelve el número de elementos de la tabla hash
        System.out.println("\nTotal elementos: " + persona.size());

        // isEmpty() devuelve true si la tabla hash está vacía
        System.out.println("Tabla hash vacía: " + persona.isEmpty());

        // replace() reemplaza el valor del elemento que tenga la clave indicada, devuelve el valor anterior
        persona.replace("nombre", "Juanito");

        System.out.println("\nImprimir con forEach()");
        persona.forEach((k, v) -> System.out.println("\tkey = " + k + ", value = " + v));


    }
}
