package org.tucno.apistream.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class _01_Stream {
    public static void main(String[] args) {
        // Stream es un interfaz funcional que permite trabajar con colecciones de datos de forma funcional
        // of es un método estático de Stream que permite crear un Stream a partir de una serie de elementos

        // FORMAS DE CREAR UN STREAM

        // 1. A partir de un array de elementos pasados como parámetro
        Stream<String> nombres = Stream.of("Paco", "Pepe", "Juan", "Luis", "Antonio");
//        nombres.forEach(System.out::println);

        // 2. A partir de un array de elementos
        String[] arr = {"Paco", "Pepe", "Juan", "Luis", "Antonio", "Manuel"};
        Stream<String> nombres2 = Stream.of(arr);
//        nombres2.forEach(System.out::println);

        // 3. Utilizando el Stream.builder
        Stream<String> nombres3 = Stream.<String>builder()
                .add("Paco")
                .add("Pepe")
                .add("Juan")
                .add("Luis")
                .build();
//        nombres3.forEach(System.out::println);

        // 4. A partir de un tipo Collection
        List<String> lista = new ArrayList<>();
        lista.add("Paco");
        lista.add("Pepe");
        lista.add("Juan");
        lista.add("Luis");

//        Stream<String> nombres4 = lista.stream();
//        nombres4.forEach(System.out::println);

        lista.stream().forEach(System.out::println); // Otra forma de hacerlo en una sola línea
    }
}
