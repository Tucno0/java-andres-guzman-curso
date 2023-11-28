package org.tucno.apistream.ejemplos;

import java.util.stream.Stream;

public class _12_OperadorReduce {
    public static void main(String[] args) {
        // OPERADOR REDUCE
        // Devuelve un Optional que contiene el resultado de aplicar la función de reducción
        // a los elementos de la secuencia de entrada
        // La función de reducción es una función binaria que acepta dos parámetros:
        // - El primer parámetro es el valor devuelto por la función de reducción en la llamada anterior
        // - El segundo parámetro es el siguiente elemento de la secuencia de entrada
        // El resultado de la función de reducción es el valor devuelto por la función de reducción

        Stream<String> nombres = Stream.of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García", "Víctor García", "Víctor García", "Víctor García")
                .distinct();

        String resultado = nombres.reduce("Resultado: ", (a, b) -> a + ", " + b);
        System.out.println(resultado);

    }
}
