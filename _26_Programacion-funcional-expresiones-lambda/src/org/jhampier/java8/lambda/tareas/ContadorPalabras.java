package org.jhampier.java8.lambda.tareas;

import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {
    Map<String, Integer> contar(String texto);
}
