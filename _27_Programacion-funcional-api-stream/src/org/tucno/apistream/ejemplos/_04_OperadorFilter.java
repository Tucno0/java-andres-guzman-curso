package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class _04_OperadorFilter {
    public static void main(String[] args) {
        // OPERADOR FILTER
        // El operador filter permite filtrar los elementos de un Stream según una condición.
        // La condición se define mediante un predicado (una expresión lambda que devuelve un booleano).
        // Si el predicado devuelve true, el elemento se incluye en el Stream resultante.

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

        List<Usuario> lista = usuarios.toList();

        System.out.println("Lista de Usuarios:");
        lista.forEach(System.out::println);
    }
}
