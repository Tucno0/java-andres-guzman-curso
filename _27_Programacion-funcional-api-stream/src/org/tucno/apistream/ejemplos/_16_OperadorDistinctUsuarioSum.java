package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _16_OperadorDistinctUsuarioSum {
    public static void main(String[] args) {
        // OPERADOR mapToInt()
        // El operador mapToInt() convierte un Stream de objetos en un Stream de valores primitivos int

        IntStream largoNombres = Stream.of("Raúl López", "Víctor García", "Javier Martínez", "Jesús Pérez", "Jorge Hernández", "Javier García", "Javier Martínez")
//                .distinct()
                .map(nombre -> {
                    String name = nombre.split(" ")[0];
                    String lastname = nombre.split(" ")[1];
                    return new Usuario(name, lastname);
                })
                .distinct()
                .mapToInt(usuario -> usuario.toString().length())
                .peek(System.out::println);

        IntSummaryStatistics estadisticas = largoNombres.summaryStatistics();

        System.out.println("\nSuma de los largos de los nombres: " + estadisticas.getSum());
        System.out.println("Promedio de los largos de los nombres: " + estadisticas.getAverage());
        System.out.println("Máximo de los largos de los nombres: " + estadisticas.getMax());
        System.out.println("Mínimo de los largos de los nombres: " + estadisticas.getMin());
        System.out.println("Número de elementos: " + estadisticas.getCount());


    }
}
