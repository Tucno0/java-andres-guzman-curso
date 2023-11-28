package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class _06_OperadorFilterSingle2 {
    public static void main(String[] args) {
        Usuario usuario = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .peek(System.out::println) // Imprimimos los usuarios
                .filter(u -> u.getId().equals(3)) // Filtramos por el id
                .findFirst().get(); // Obtenemos el primer elemento del stream
                // findFirst() es un operador terminal que devuelve un Optional es decir que el Stream termina aquí

        System.out.println("\nUsuario: " + usuario);
    }
}
