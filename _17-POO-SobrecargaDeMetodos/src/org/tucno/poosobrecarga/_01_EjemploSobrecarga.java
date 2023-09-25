package org.tucno.poosobrecarga;

public class _01_EjemploSobrecarga {
    public static void main(String[] args) {

        System.out.println("Suma de 2 enteros: " + Calculadora.sumar(2, 3));
        System.out.println("Suma de 2 flotantes: " + Calculadora.sumar(2.5f, 3.5f));
        System.out.println("Suma de 1 flotante y 1 entero: " + Calculadora.sumar(2.5f, 3));
        System.out.println("Suma de 1 entero y 1 flotante: " + Calculadora.sumar(2, 3.5f));
        System.out.println("Suma de 2 doubles: " + Calculadora.sumar(2.5, 3.5));
        System.out.println("Suma de 3 doubles: " + Calculadora.sumar(2.5, 3.5, 4.5));
        System.out.println("Suma de 2 cadenas: " + Calculadora.sumar("2", "3"));
        System.out.println("Suma de 3 enteros: " + Calculadora.sumar(2, 3, 4));

        System.out.println("\nSuma de 2 longs: " + Calculadora.sumar(2L, 3L)); // Es compatible
        System.out.println("Suma de 1 int y 1 unicode: " + Calculadora.sumar(10, '@')); // Es compatible
        System.out.println("Suma de 1 float y 1 unicode: " + Calculadora.sumar(10F, '@')); // Es compatible
    }
}
