package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class _18_ConvertirListToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Raúl", "López"));
        lista.add(new Usuario("Víctor", "García"));
        lista.add(new Usuario("Javier", "Martínez"));
        lista.add(new Usuario("Jesús", "Pérez"));
        lista.add(new Usuario("Jorge", "Hernández"));
        lista.add(new Usuario("Javier", "García"));
        lista.add(new Usuario("Javier", "Martínez"));
        lista.add(new Usuario("javier", "Rodríguez"));

        // Convertir una lista a un Stream con el método stream()
        Stream<Usuario> usuarios = lista.stream();
//        usuarios.forEach(System.out::println);

        Stream<String> usuariosString = usuarios
                .map( usuario -> usuario.toString().toUpperCase())
                .flatMap( u -> {
                    if (u.contains("Javier".toUpperCase())) {
                        return Stream.of(u);
                    }
                    return Stream.empty();
                });

        usuariosString.forEach(System.out::println);

    }
}
