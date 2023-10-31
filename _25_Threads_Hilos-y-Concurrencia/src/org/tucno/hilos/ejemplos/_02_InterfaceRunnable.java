package org.tucno.hilos.ejemplos;

import org.tucno.hilos.ejemplos.runnable.ViajeTarea;

public class _02_InterfaceRunnable {
    public static void main(String[] args) {
        // Se crea un hilo nuevo que ejecuta el método run() de la clase ViajeTarea
        new Thread(new ViajeTarea("Barcelona")).start();
        new Thread(new ViajeTarea("Madrid")).start();
        new Thread(new ViajeTarea("Londres")).start();
        new Thread(new ViajeTarea("Paris")).start();

    }
}
