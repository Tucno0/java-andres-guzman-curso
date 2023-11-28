package org.jhampier.java8.lambda;

import org.jhampier.java8.lambda.aritmetica.Aritmetica;
import org.jhampier.java8.lambda.aritmetica.Calculadora;

public class _04_InterfaceFunctional {
    public static void main(String[] args) {
        // Implementación de la interfaz funcional
        Aritmetica suma = (a, b) -> a + b; // Double::sum es equivalente a (a, b) -> a + b
        Aritmetica resta = (a, b) -> a - b;
        Aritmetica multiplicacion = (a, b) -> a * b;
        Aritmetica division = (a, b) -> a / b;

        Calculadora calculadora = new Calculadora();
        System.out.println("Suma: " + calculadora.computar(10, 5, suma));
        System.out.println("Resta: " + calculadora.computar(10, 5, resta));
        System.out.println("Multiplicación: " + calculadora.computar(10, 5, multiplicacion));
        System.out.println("División: " + calculadora.computar(10, 5, division));

        System.out.println("\nSuma: " + calculadora.computarConBiFunction(10, 5, (a, b) -> a + b));
        System.out.println("Resta: " + calculadora.computarConBiFunction(10, 5, (a, b) -> a - b));
        System.out.println("Multiplicación: " + calculadora.computarConBiFunction(10, 5, (a, b) -> a * b));
        System.out.println("División: " + calculadora.computarConBiFunction(10, 5, (a, b) -> a / b));
    }
}
