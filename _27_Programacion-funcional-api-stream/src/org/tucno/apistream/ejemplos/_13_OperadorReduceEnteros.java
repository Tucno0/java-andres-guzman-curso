package org.tucno.apistream.ejemplos;

import java.util.stream.Stream;

public class _13_OperadorReduceEnteros {
    public static void main(String[] args) {

        Stream<Integer> numeros = Stream.of(5, 10, 15, 20, 25, 30, 35, 40, 45, 50);

        Integer resultado = numeros.reduce(0, (a, b) -> a + b);
        // forma corta: Integer resultado = numeros.reduce(0, Integer::sum);
        System.out.println("resultado = " + resultado);

    }
}
