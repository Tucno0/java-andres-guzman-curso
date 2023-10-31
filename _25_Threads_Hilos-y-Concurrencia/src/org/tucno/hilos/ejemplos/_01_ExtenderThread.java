package org.tucno.hilos.ejemplos;

import org.tucno.hilos.ejemplos.threads.NombreThread;

public class _01_ExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        // Cuando se crea la instancia es un hilo nuevo que todavía no se está ejecutando.
        // A este estado se le llama new.
        Thread hilo1 = new NombreThread("Hilo 1");
        System.out.println("Estado del " + hilo1.getName() + ": " + hilo1.getState());

        // Cuando se ejecuta el método start() del hilo, el hilo pasa al estado runnable.
        hilo1.start(); // El start() es el que ejecuta el método run() del hilo.

        // Cuando se ejecuta el método sleep() del hilo, el hilo pasa al estado blocked.
        // Pausa la ejecución del hilo principal por 5 segundos. El hilo principal es el que ejecuta el método main().
        Thread.sleep(5000);

        Thread hilo2 = new NombreThread("Hilo 2");
        System.out.println("Estado del " + hilo2.getName() + ": " + hilo1.getState());
        hilo2.start();

        Thread hilo3 = new NombreThread("Hilo 3");
        System.out.println("Estado del " + hilo3.getName() + ": " + hilo1.getState());
        hilo3.start();

        System.out.println("\nEstado del hilo 1: " + hilo1.getState());
        System.out.println("Estado del hilo 2: " + hilo2.getState());
        System.out.println("Estado del hilo 3: " + hilo3.getState());
    }
}
