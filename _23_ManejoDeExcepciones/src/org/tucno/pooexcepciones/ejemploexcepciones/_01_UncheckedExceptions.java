package org.tucno.pooexcepciones.ejemploexcepciones;

import javax.swing.*;

public class _01_UncheckedExceptions {
    // Se puede propagar la excepción en el método main, pero no es recomendable
    public static void main(String[] args) {
        // TIPOS DE EXCEPCIONES

        // ================================================================================================
        // Unchecked Exceptions: No nos obliga a capturarlas los errores es decir, no es necesario usar try-catch
        // Conformado por las clases que heredan de RuntimeException
        // ClassCastException, NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException, NumberFormatException, etc.

        Calculadora calculadora = new Calculadora();

        String valor = JOptionPane.showInputDialog("Ingrese un número");
        int divisor;
        double division;

        try {
            divisor = Integer.parseInt(valor);
            division = 10 / divisor; // ArithmeticException
            System.out.println(division);

        } catch (NumberFormatException nfe) {
            System.out.println("Se detectó una excepción: por favor ingrese un número válido: " + nfe.getMessage());
            main(args);

        } catch (ArithmeticException ae) {
            System.out.println("Capturando la excepción en tiempo de ejecución : " + ae.getMessage());
            main(args);

        } finally { // Opcional
            // Se usa para cerrar recursos como conexiones a base de datos, archivos, etc.
            System.out.println("Ejecutando el bloque finally");
        }

        System.out.println("Continuando con la ejecución del programa");

    }
}
