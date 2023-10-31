package org.tucno.hilos.ejemplosync;

import org.tucno.hilos.ejemplosync.runnable.Consumidor;
import org.tucno.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.ThreadLocalRandom;

public class _07_EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        // Creamos una panadería.
        Panaderia panaderia = new Panaderia();

        // Creamos un panadero
        new Thread(() -> {
            // El panadero hornea 10 panes.
            for (int i = 0; i < 10; i++) {
                panaderia.hornear("Pan N° " + i);

                try {
                    // El panadero tarda entre 0.5 y 2 segundos en hornear cada pan.
                    // ThreadLocalRandom es una clase que genera números aleatorios.
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Creamos un consumidor
        new Thread(() -> {
            // El consumidor consume 10 panes.
            for (int i = 0; i < 10; i++) {
                panaderia.consumir();
            }
        }).start();
    }
}
