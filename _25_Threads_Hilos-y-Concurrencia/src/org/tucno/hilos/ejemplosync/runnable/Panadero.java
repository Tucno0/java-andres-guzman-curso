package org.tucno.hilos.ejemplosync.runnable;

import org.tucno.hilos.ejemplosync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {
    // Tanto el panadero como el consumidor tienen que conocer la panadería.
    // Deben tener el mismo atributo panadería.
    // Este es el objeto monitor. Es el objeto que se usa para sincronizar los hilos.
    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
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
    }
}
