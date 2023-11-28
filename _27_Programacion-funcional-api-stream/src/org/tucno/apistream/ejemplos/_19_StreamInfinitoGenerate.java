package org.tucno.apistream.ejemplos;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class _19_StreamInfinitoGenerate {
    public static void main(String[] args) {
        // generate() genera un Stream infinito de elementos
        Stream.generate(() -> Math.random())
                .limit(5) // limita el número de elementos
                .forEach(System.out::println);

        AtomicInteger contador = new AtomicInteger(0);

        Stream.generate(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return contador.incrementAndGet();
        })
                .limit(5) // limita el número de elementos
                .forEach(System.out::println);
    }
}
