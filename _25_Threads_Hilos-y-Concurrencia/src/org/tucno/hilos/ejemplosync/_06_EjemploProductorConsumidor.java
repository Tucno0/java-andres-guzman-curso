package org.tucno.hilos.ejemplosync;

import org.tucno.hilos.ejemplosync.runnable.Consumidor;
import org.tucno.hilos.ejemplosync.runnable.Panadero;

public class _06_EjemploProductorConsumidor {
    public static void main(String[] args) {
        // Creamos una panadería.
        Panaderia panaderia = new Panaderia();
        // Creamos un panadero y un consumidor.
        new Thread(new Panadero(panaderia)).start();
        new Thread(new Consumidor(panaderia)).start();
    }
}
