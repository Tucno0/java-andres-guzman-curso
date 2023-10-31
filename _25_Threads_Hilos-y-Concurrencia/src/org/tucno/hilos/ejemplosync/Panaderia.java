package org.tucno.hilos.ejemplosync;

public class Panaderia {
    private String pan;
    private boolean disponible; // Indica si el pan está disponible o no.

    // El modificador synchronized indica que el método hornear() solo puede ser ejecutado por un hilo a la vez.
    // Este modificador es muy importante para poder usar el método wait() y notifyAll().
    public synchronized void hornear(String masa) {
        // Si el pan está disponible, el panadero espera a que el cliente consuma el pan.
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Si el pan no está disponible, el panadero hornea el pan y lo pone disponible.
        this.pan = masa;
        System.out.println("Panadero horneando: " + this.pan);
        // El pan está disponible.
        disponible = true;
        // Notificamos al cliente de que el pan está disponible.
        notifyAll();
    }

    public synchronized String consumir() {
        // Si el pan no está disponible, el cliente espera a que el panadero hornee el pan.
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        // Si el pan está disponible, el cliente consume el pan y lo pone no disponible.
        System.out.println("Cliente consumiendo: " + this.pan);
        // El pan no está disponible.
        disponible = false;
        // Notificamos al panadero de que el pan ha sido consumido.
        notifyAll();
        // Devolvemos el pan consumido.
        return pan;
    }
}
