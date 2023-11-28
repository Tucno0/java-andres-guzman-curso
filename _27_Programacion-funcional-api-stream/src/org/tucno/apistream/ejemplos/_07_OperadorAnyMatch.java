package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class _07_OperadorAnyMatch {
    public static void main(String[] args) {
        // OPERADOR ANYMATCH
        // Es un operador terminal que devuelve un booleano
        // Devuelve un booleano si se cumple la condición en algún elemento del stream

        boolean existe = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .peek(System.out::println) // Imprimimos los usuarios
                .anyMatch(u -> u.getId().equals(3)); // Filtramos por el id

        System.out.println("\nExiste el usuario con id 3: " + existe);
    }
}
