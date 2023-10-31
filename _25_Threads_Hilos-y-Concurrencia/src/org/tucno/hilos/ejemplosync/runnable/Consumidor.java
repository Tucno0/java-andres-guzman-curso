package org.tucno.hilos.ejemplosync.runnable;

import org.tucno.hilos.ejemplosync.Panaderia;

public class Consumidor implements Runnable {
    // Tanto el panadero como el consumidor tienen que conocer la panadería.
    // Deben tener el mismo atributo panadería.
    // Este es el objeto monitor. Es el objeto que se usa para sincronizar los hilos.
    private Panaderia panaderia;

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        // El consumidor consume 10 panes.
        for (int i = 0; i < 10; i++) {
            panaderia.consumir();
        }
    }
}
