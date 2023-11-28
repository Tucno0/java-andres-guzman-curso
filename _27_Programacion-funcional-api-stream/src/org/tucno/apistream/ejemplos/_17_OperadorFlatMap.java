package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class _17_OperadorFlatMap {
    public static void main(String[] args) {

        // OPERADOR flatMap()
        // El operador flatMap() convierte un Stream de objetos en un Stream de objetos de otro tipo o en un Stream de valores primitivos
        // El operador flatMap() recibe como parámetro una función que devuelve un Stream de objetos o un Stream de valores primitivos

        Stream<Usuario> usuarios = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .flatMap(u -> {
                    if (u.getNombre().equalsIgnoreCase("Javier")) {
                        return Stream.of(u); // Stream<Usuario>
                    }
                    return Stream.empty(); // Stream<Usuario>
                });

        usuarios.forEach(System.out::println);
    }
}
