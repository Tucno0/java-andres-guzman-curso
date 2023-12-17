package org.tucno.apistream.tareas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Como desafió consiste en un arreglo de 100 elementos del 1 al 100, del tipo int, utilizando el api stream se pide eliminar los divisibles en 10, luego convertir los elementos restante del flujo en tipo double y dividirlos en 2, para finalmente devolver la suma total de todos ellos usando el operador terminal reduce. El resultado debería ser 2250.0
 */
public class Tarea31 {
    public static void main(String[] args) {
        AtomicInteger contador = new AtomicInteger(0);

        double suma = Stream.generate(() -> contador.incrementAndGet())
                .limit(100)
                .filter(numero -> numero % 10 != 0)
                .mapToDouble(numero -> numero / 2.0)
                .reduce(0, (a, b) -> a + b);

        System.out.println(suma);

    }
}
