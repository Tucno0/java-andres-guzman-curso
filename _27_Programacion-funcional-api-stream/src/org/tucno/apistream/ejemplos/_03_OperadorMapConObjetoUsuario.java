package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class _03_OperadorMapConObjetoUsuario {
    public static void main(String[] args) {

        Stream<Usuario> usuarios = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .peek(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                });

        List<Usuario> lista = usuarios.toList();

        System.out.println("Lista de Usuarios:");
        lista.forEach(System.out::println);
    }
}
