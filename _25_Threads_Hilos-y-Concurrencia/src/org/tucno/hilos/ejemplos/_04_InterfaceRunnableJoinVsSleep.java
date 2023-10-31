package org.tucno.hilos.ejemplos;

public class _04_InterfaceRunnableJoinVsSleep {
    public static void main(String[] args) throws InterruptedException {
        // Se obtiene el hilo principal. El hilo principal es el que ejecuta el método main().
        Thread main = Thread.currentThread();

        // Creación de la función anónima con Java 8. Expresión lambda.
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                // Con getName() se obtiene el nombre del hilo actual.
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    // El método sleep() pausa la ejecución del hilo actual. En este caso, el hilo hijo.
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());
            System.out.println("Estado del hilo Main: " + main.getState());
        };

        Thread v1 = new Thread(viaje, "México");
        Thread v2 = new Thread(viaje, "España");
        Thread v3 = new Thread(viaje, "Francia");
        Thread v4 = new Thread(viaje, "Italia");

        // Cuando se ejecuta el método start() del hilo, el hilo pasa al estado runnable.
        v1.start();
        v2.start();
        v3.start();
        v4.start();

        // El método join() espera a que los hilos hijos terminen su ejecución.
        v1.join(); // Se une el hilo principal con el hilo v1.
        v2.join(); // Se une el hilo principal con el hilo v2.
        v3.join(); // Se une el hilo principal con el hilo v3.
        v4.join(); // Se une el hilo principal con el hilo v4.

        // El método sleep() pausa la ejecución del hilo actual. En este caso, el hilo principal.
        // No pausa la ejecución de los hilos hijos.
        // Es un método estático, por lo que se ejecuta directamente desde la clase Thread.
        // Siempre se ejecuta desde el hilo actual.
//        Thread.sleep(1000);

        System.out.println("Continuando la ejecución del método main(): " + main.getName());
    }
}
