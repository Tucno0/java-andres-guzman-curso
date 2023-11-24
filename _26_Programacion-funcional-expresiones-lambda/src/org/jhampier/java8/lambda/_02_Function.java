package org.jhampier.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _02_Function {
    public static void main(String[] args) {
        // Function es una interfaz funcional que recibe un parámetro y devuelve un valor
        // Tiene el método apply que recibe un parámetro y devuelve un valor
        // Function<tipo de dato del parámetro, tipo de dato del valor de retorno> nombre = parámetro -> {cuerpo de la función}
        Function<String, String> funtion1 = param -> "Hola que tal! " + param;
        String resultado = funtion1.apply("Juan");
        System.out.println(resultado);

        Function<String, String> funtion2 = String::toUpperCase; // String::toUpperCase es equivalente a x -> x.toUpperCase()
        System.out.println(funtion2.apply("Juan"));

        // BiFunction es una interfaz funcional que recibe dos parámetros y devuelve un valor
        BiFunction<String, String, String> biFunction1 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        String resp2 = biFunction1.apply("Juan", "Pablo");
        System.out.println(resp2);

        BiFunction<String, String, Integer> biFunction2 = (a, b) -> a.compareTo(b);
        System.out.println(biFunction2.apply("Juan", "Juan")); // 0 si son iguales, -1 si a < b, 1 si a > b

        BiFunction<String, String, String> biFunction3 = (a ,b) -> a.concat(b);
        System.out.println(biFunction3.apply("Juan", "Pablo"));
    }
}
