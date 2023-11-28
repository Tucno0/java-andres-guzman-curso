package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class _10_OperadorFilterEmpty {
    // isEmpty() es un método de la clase String que devuelve true si la cadena está vacía

    // OPERADOR COUNT
    // Devuelve el número de elementos de la secuencia de entrada como un long
    public static void main(String[] args) {
        long countEmptys = Stream
                .of("Raúl López", "Víctor García", "", "Jesús Pérez", "Jorge Hernández", "")
                .filter(n -> n.isEmpty())
                .peek(System.out::println)
                .count();

        System.out.println("Número de cadenas vacías: " + countEmptys);
    }
}
