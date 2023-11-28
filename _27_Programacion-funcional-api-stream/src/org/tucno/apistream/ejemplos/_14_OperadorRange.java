package org.tucno.apistream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class _14_OperadorRange {
    public static void main(String[] args) {

        // IntStream
        // Es una subinterfaz de Stream que trabaja con tipos de datos primitivos
        // Sirve para trabajar con rangos de números enteros
        // Tambien hay LongStream y DoubleStream para trabajar con rangos de números long y double

        // OPERADOR RANGE
        // Devuelve una secuencia de números enteros en un rango especificado
        // El primer parámetro es el valor inicial del rango (incluido)
        // El segundo parámetro es el valor final del rango (excluido)

        // OPERADOR rangeClosed
        // Devuelve una secuencia de números enteros en un rango especificado (incluyendo el valor final)

        IntStream numeros = IntStream.range(5, 21).peek(System.out::println);

//        Integer resultado = numeros.reduce(0, (a, b) -> a + b);

        // OPERADOR SUM
        // Operador de IntStream que devuelve un Integer
        // Devuelve la suma de los elementos de la secuencia de entrada

//        Integer resultado = numeros.sum();

        // OPERADOR SUMARYSTATISTICS
        // Operador de IntStream que devuelve un IntSummaryStatistics
        // Devuelve un objeto IntSummaryStatistics que contiene estadísticas de la secuencia de entrada
        // Las estadísticas son:
        // - count: número de elementos de la secuencia de entrada
        // - sum: suma de los elementos de la secuencia de entrada
        // - min: valor mínimo de la secuencia de entrada
        // - max: valor máximo de la secuencia de entrada
        // - average: media de los elementos de la secuencia de entrada

        IntSummaryStatistics resultado = numeros.summaryStatistics();
        System.out.println("\nresultado = " + resultado);

        System.out.println("\nmax = " + resultado.getMax());
        System.out.println("min = " + resultado.getMin());
        System.out.println("sum = " + resultado.getSum());
        System.out.println("average = " + resultado.getAverage());
        System.out.println("count = " + resultado.getCount());

    }
}
