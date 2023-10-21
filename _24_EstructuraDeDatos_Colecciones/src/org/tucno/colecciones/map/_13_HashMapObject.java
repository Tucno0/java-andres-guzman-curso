package org.tucno.colecciones.map;

import java.util.HashMap;
import java.util.Map;

public class _13_HashMapObject {

    public static <T> void printMap(Map<String, T> map) {
        map.forEach((k, v) -> {
            if (v instanceof Map) {
                printMap((Map<String, T>) v);
            } else {
                System.out.println("key = " + k + ", value = " + v);
            }
        });
    }
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>();

        persona.put(null, "1234");
        persona.put(null, "12345");
        persona.put("nombre", "Juan");
        persona.put("nombre2", "Juan");
        persona.put("apellido", "Pere");
        persona.put("apellido", "Perez");
        persona.put("email", "juan@gmail.com");
        persona.put("edad", 30);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);


        Map<String, String> direccion = new HashMap<>();

        direccion.put("Pais", "USA");
        direccion.put("Estado", "California");
        direccion.put("Ciudad", "Los Angeles");
        direccion.put("Calle", "Av. 5");
        direccion.put("No", "123");

        // Se puede añadir un mapa a otro mapa
        persona.put("direccion", direccion);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("Pais");
        System.out.println("\npais = " + pais);
        String estado = direccionPersona.get("Estado");
        System.out.println("estado = " + estado);
        String ciudad = direccionPersona.get("Ciudad");
        System.out.println("ciudad = " + ciudad);
        // getOrDefault() devuelve el valor de la clave indicada, si no existe la clave devuelve el valor por defecto
        String barrio = direccionPersona.getOrDefault("Barrio", "Barrio 1");
        System.out.println("barrio = " + barrio);

        System.out.println("\nImprimir persona");
        printMap(persona);
        System.out.println("\nImprimir direccion");
        printMap(direccion);
    }
}
