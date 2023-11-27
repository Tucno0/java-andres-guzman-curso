package org.tucno.apistream.ejemplos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_OperadorMap {
    public static void main(String[] args) {
        // Stream es un interfaz funcional que permite trabajar con colecciones de datos de forma funcional
        // of es un método estático de Stream que permite crear un Stream a partir de una serie de elementos
        // peek es un método intermedio de Stream que permite realizar una operación con cada elemento del Stream
        // map es un método intermedio de Stream que permite transformar los elementos de un Stream

        Stream<String> nombres = Stream
                .of("Raúl", "Víctor", "Javier", "Jesús")
                .map(nombre -> nombre.toUpperCase())
                .peek(System.out::println)
                .map(nombre -> nombre.toLowerCase())
                .peek(System.out::println);

//        nombres.forEach(System.out::println);

        System.out.println();

        // Otra forma de hacerlo sin crear el Stream intermedio
        Stream.of("Paco", "Pepe", "Juan", "Luis", "Antonio")
                .map(nombre -> nombre.toUpperCase())
                .forEach(System.out::println);

        // Convertir un Stream de String a una Lista de String
        // collect es un método final de Stream que permite convertir un Stream en una colección
        // Collectors es una clase que contiene métodos estáticos que permiten convertir un Stream en una colección
        // toList es un método estático de Collectors que permite convertir un Stream en una Lista
        List<String> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
    }
}
