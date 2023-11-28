package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;
public class _09_ApiOptional {
    public static void main(String[] args) {
        // API Optional
        // Optional es un contenedor que puede o no contener un valor no nulo.
        // Sirve para evitar NullPointerException.
        // Si contiene un valor no nulo, el método isPresent() devuelve true y el método get() devuelve el valor.
        // Si el Optional está vacío, el método isPresent() devuelve false y el método get() lanza una excepción NoSuchElementException.

        Stream<Usuario> usuarios = Stream
                .of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García")
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .filter(u -> u.getNombre().equals("Javierx"))
                .peek(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    usuario.setNombre(nombre);
                });
//                .findFirst().orElseGet(() -> new Usuario("Nombre por defecto", "Apellido por defecto"));

        Optional<Usuario> usuario = usuarios.findFirst();

        // orElse() devuelve el valor del Optional si está presente, o el valor por defecto si no lo está.
//        System.out.println("Usuario: " + usuario.orElse(new Usuario("Nombre por defecto", "Apellido por defecto")));

        // orElseGet() devuelve el valor del Optional si está presente, o el valor devuelto por Supplier si no lo está.
//        System.out.println("Usuario: " + usuario.orElseGet(() -> new Usuario("Nombre por defecto", "Apellido por defecto")));

        // orElseThrow() devuelve el valor del Optional si está presente, o lanza la excepción devuelta por Supplier si no lo está. Si no se especifica Supplier, lanza NoSuchElementException.
//        System.out.println("Usuario: " + usuario.orElseThrow());
//        System.out.println("Usuario: " + usuario.orElseThrow(() -> new RuntimeException("No hay usuarios")));

        // isPresent() devuelve true si el Optional contiene un valor no nulo.
//        if (usuario.isPresent()) {
//            System.out.println("Usuario: " + usuario.get());
//        } else {
//            System.out.println("No hay usuarios");
//        }

        // isEmtpy() devuelve true si el Optional está vacío.
        if (usuario.isEmpty()) {
            System.out.println("No hay usuarios");
        } else {
            System.out.println("Usuario: " + usuario.get());
        }


    }
}
