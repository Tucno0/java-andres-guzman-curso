package org.tucno.pooexcepciones.ejemploexcepciones;

import javax.swing.*;

public class _02_CheckedExceptions {
    // Se puede propagar la excepción en el método main, pero no es recomendable
    public static void main(String[] args) {
        // TIPOS DE EXCEPCIONES

        // ===============================================================================================
        // Checked Exceptions: Nos obliga a capturarlas los errores es decir, es necesario usar try-catch
        // Conformado por las clases que heredan de Exception excepto RuntimeException
        // IOException, SQLException, ClassNotFoundException, etc.
        // También se pueden crear nuestras propias excepciones checked

        Calculadora calculadora = new Calculadora();

        String numerador = JOptionPane.showInputDialog("Ingrese un entero numerador");
        String denominador = JOptionPane.showInputDialog("Ingrese un entero denominador");

        int divisor;
        double division;

        try {
//            divisor = Integer.parseInt(valor);
//            division= calculadora.dividir(10, divisor);; // ArithmeticException
//            System.out.println("division = " + division);

            double division2 = calculadora.dividir(numerador, denominador);
            System.out.println("division2 = " + division2);

        } catch (NumberFormatException nfe) {
            System.out.println("Se detectó una excepción, por favor ingrese un número válido: " + nfe.getMessage());
            main(args);

        } catch (DivisionPorZeroException ae) {
            System.out.println("Capturando la excepción en tiempo de ejecución : " + ae.getMessage());
            main(args);

        } catch (FormatoNumeroException fne) {
            System.out.println("Se detecto una excepción, ingrese un numero valido:  " + fne.getMessage());
            // printStackTrace() es un método de la clase Exception que imprime el stacktrace de la excepción
            // un stacktrace es una lista de los métodos que se han llamado hasta llegar al método que lanzó la excepción
            fne.printStackTrace(System.out); // Imprime el stacktrace de la excepción
            main(args);

        } finally { // Opcional
            // Se usa para cerrar recursos como conexiones a base de datos, archivos, etc.
            System.out.println("Ejecutando el bloque finally");
        }

        System.out.println("Continuando con la ejecución del programa");
    }
}
