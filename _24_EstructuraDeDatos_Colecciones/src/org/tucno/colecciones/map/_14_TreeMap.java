package org.tucno.colecciones.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class _14_TreeMap {
    // TreeMap
    // - Es una implementación de la interfaz Map que mantiene los elementos ordenados por clave
    // - Los elementos se ordenan de acuerdo al orden natural de las claves o de acuerdo a un comparador
    // - No permite claves null
    // - No permite valores null
    // - Es más lento que HashMap
    // - Es más rápido que LinkedHashMap

    public static void main(String[] args) {
//        Map<String, Object> persona = new TreeMap<>(); // ordena las claves de forma ascendente
//        Map<String, Object> persona = new TreeMap<>((a, b) -> b.compareTo(a)); // ordena las claves de forma descendente
//        Map<String, Object> persona = new TreeMap<>(Comparator.reverseOrder()); // ordena las claves de forma descendente

        // ordena las claves de forma ascendente por longitud de la clave
        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length));

        // ordena las claves de forma descendente por longitud de la clave
//        Map<String, Object> persona = new TreeMap<>(Comparator.comparing(String::length).reversed());

        persona.put("nombre", "Juan");
        persona.put("apellido", "Perez");
        persona.put("email", "juan@gmail.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new TreeMap<>();
        direccion.put("Pais", "USA");
        direccion.put("Estado", "California");
        direccion.put("Ciudad", "Los Angeles");
        direccion.put("Calle", "Av. 5");
        direccion.put("No", "123");

        persona.put("direccion", direccion);

        System.out.println("\nImprimir persona\n");
        persona.forEach((k, v) -> {
            System.out.print(k);
            if (v instanceof Map) {
                System.out.println();
                ((Map<?, ?>) v).forEach((k1, v1) -> {
                    System.out.println("\t" + k1 + " : " + v1);
                });
            } else {
                System.out.println(" : " + v);
            }
        });
    }
}
