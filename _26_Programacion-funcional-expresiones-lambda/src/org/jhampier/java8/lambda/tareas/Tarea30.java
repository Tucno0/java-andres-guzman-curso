package org.jhampier.java8.lambda.tareas;

import java.util.HashMap;
import java.util.Map;

/*
    Para la tarea se pide como requerimiento escribir una expresión lambda que cuenta la cantidad de veces que se repiten las palabras de una frase y devuelva la más repetida, según lo siguiente:
    La expresión lambda debe recibir por argumento una frase u oración y devolver un objeto Map que contenga la palabra mas repetida de la frase como llave y la cantidad de veces que se repite como valor.
 */
public class Tarea30 {
    public static void main(String[] args) {
        ContadorPalabras contador = (texto) -> {
            String[] palabras = texto.replace(",", "").replace(".", "").split(" ");

            Map<String, Integer> mapa = new HashMap<>();

            int max = 0;
            String palabraMasRepetida = "";

            for (String palabra : palabras) {
                if (mapa.containsKey(palabra)) {
                    mapa.put(palabra, mapa.get(palabra) + 1);
                } else {
                    mapa.put(palabra, 1);
                }

                if (mapa.get(palabra) > max) {
                    max = mapa.get(palabra);
                    palabraMasRepetida = palabra;
                }
            }

            Map<String, Integer> mapaResultado = new HashMap<>();
            mapaResultado.put(palabraMasRepetida, max);

            return mapaResultado;
        };

        Map<String, Integer> palabrasContadas = contador.contar("Lorem ipsum dolor sit amet, consectetur ipsum adipiscing elit. Sed non risus. Suspendisse ipsum lectus tortor, ipsum dignissim sit amet, adipiscing nec, ipsum ultricies sed, dolor.");

        palabrasContadas.forEach((k, v) -> {
            System.out.println("Palabra: " + k + ", Cantidad: " + v);
        });
    }
}
