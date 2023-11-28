package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class _05_OperadorFilterSingle {
    public static void main(String[] args) {
        Stream<Usuario> usuarios = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .filter(u -> u.getNombre().equals("Javier"))
                .peek(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                });

        // Optional es un contenedor que puede o no contener un valor no nulo.
        // Si contiene un valor no nulo, el método isPresent() devuelve true y el método get() devuelve el valor.

        // findFirst() devuelve un Optional con el primer elemento del Stream.
        // Si el Stream está vacío, devuelve un Optional vacío.
        // Para obtener el valor del Optional, se usa el método get().
        Optional<Usuario> usuario = usuarios.findFirst();

        System.out.println("Usuario: " + usuario.get());
    }
}
