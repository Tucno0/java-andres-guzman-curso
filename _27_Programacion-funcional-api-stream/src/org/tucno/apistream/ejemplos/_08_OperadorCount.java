package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class _08_OperadorCount {
    public static void main(String[] args) {
        // OPERADOR COUNT
        // Es un operador terminal que devuelve un long con el número de elementos del stream

        long count = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .peek(System.out::println) // Imprimimos los usuarios
                .count();

        System.out.println("\nNúmero de usuarios: " + count);
    }
}
