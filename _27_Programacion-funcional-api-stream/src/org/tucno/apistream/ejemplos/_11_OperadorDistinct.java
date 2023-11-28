package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class _11_OperadorDistinct {
    public static void main(String[] args) {
        // OPERADOR DISTINCT
        // Devuelve una secuencia de elementos distintos de la secuencia de entrada
        // El operador distinct() utiliza el método equals() para determinar si dos elementos son iguales
        // Si el método equals() no está implementado en la clase de los elementos de la secuencia de entrada,
        // se utilizará el método hashCode() para determinar si dos elementos son iguales

        Stream<String> nombres = Stream.of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García", "Víctor García", "Víctor García", "Víctor García")
                .distinct();

        nombres.forEach(System.out::println);

    }
}
