package org.jhampier.java8.lambda.tareas;

import java.util.function.Function;

public class Tarea29 {
    // Expresión Lambda que elimine espacios, comas y puntos de una frase y además la devuelva la frase convertida en mayúscula.
    public static void main(String[] args) {
        String texto = "Expresión Lambda que elimine espacios, comas y puntos de una frase y además la devuelva la frase convertida en mayúscula.";

        Function<String, String> funcion = (frase) -> {
            return frase.replace(" ", "").replace(",", "").replace(".", "").toUpperCase();
        };

        String textoConvertido = funcion.apply(texto);
        System.out.println("textoConvertido = " + textoConvertido);
    }
}
