package org.tucno.hilos.ejemplos.threads;


// HILOS - THREADS
// Los hilos son la unidad de ejecución de un programa.
// Un programa puede tener varios hilos de ejecución.
// Cada hilo de ejecución tiene su propio stack de ejecución.
// Los hilos comparten el heap de ejecución. El heap es donde se almacenan los objetos.
// Los hilos se ejecutan concurrentemente. Esto significa que los hilos se ejecutan en paralelo.
// El ciclo de vida de un hilo es: new, runnable, running, blocked, dead.
// new: el hilo se crea. Todavía no se ejecuta.
// runnable: el hilo está listo para ejecutarse. Todavía no se ejecuta.
// running: el hilo se está ejecutando.
// blocked: el hilo está bloqueado. No se está ejecutando.
// Terminated: el hilo ha terminado de ejecutarse.
// dead: el hilo ha terminado de ejecutarse.

public class NombreThread extends Thread {

    public NombreThread(String name) {
        super(name);
    }

    // Cuando se ejecuta el método start() de la clase Thread, se ejecuta el método run() de la clase Thread.
    // El método run() de la clase Thread es el método que se ejecuta en un hilo de ejecución.
    @Override
    public void run() {
        System.out.println("Se ha iniciado el hilo " + getName() + ".");

        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(getName());
        }

        System.out.println("Fin del hilo " + getName() + ".");
    }
}
