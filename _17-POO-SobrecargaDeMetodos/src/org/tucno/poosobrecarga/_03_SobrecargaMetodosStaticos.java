package org.tucno.poosobrecarga;
import static org.tucno.poosobrecarga.Calculadora.*;
public class _03_SobrecargaMetodosStaticos {
    public static void main(String[] args) {
        System.out.println("sumar 3 ints: " + sumar(2, 3, 4));
        System.out.println("sumar 4 ints: " + sumar(2, 3, 4, 5));
        System.out.println("sumar 5 ints: " + sumar(2, 3, 4, 5, 6));

        System.out.println("\nsumar 3 floats: " + sumar(2.5f, 3.5f, 4.5f));
        System.out.println("sumar float + n ints: " + sumar(2.5f, 3, 4, 5, 6));

        System.out.println("\nsumar 3 doubles: " + sumar(2.5, 3.5, 4.5));
        System.out.println("sumar double + n ints: " + sumar(2.5, 3, 4, 5, 6));
        System.out.println("sumar 5 doubles: " + sumar(2.5, 3.5, 4.5, 5.5, 6.5));
    }
}
