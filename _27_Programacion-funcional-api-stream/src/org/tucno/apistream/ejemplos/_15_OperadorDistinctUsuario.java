package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class _15_OperadorDistinctUsuario {
    public static void main(String[] args) {
        // El operador distinct() cuando se aplica a un Stream de objetos, utiliza el método equals() de los objetos
        // para determinar si dos objetos son iguales o no

        Stream<Usuario> usuarios = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García", "Javier Martínez")
//                .distinct()
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .distinct();

        usuarios.forEach(System.out::println);
    }
}
