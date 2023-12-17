package org.tucno.apistream.tareas;

import java.util.Arrays;
import java.util.function.Function;

public class Tarea32 {
    public static void main(String[] args) {
        Function<Integer[], Integer> mayor = (numeros) -> {
            return Arrays.stream(numeros)
                    .max((a, b) -> a - b)
                    .orElse(null);
        };

        Integer numMayor = mayor.apply(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(numMayor);
    }
}
