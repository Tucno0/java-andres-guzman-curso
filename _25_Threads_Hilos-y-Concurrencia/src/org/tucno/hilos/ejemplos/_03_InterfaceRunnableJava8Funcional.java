package org.tucno.hilos.ejemplos;

public class _03_InterfaceRunnableJava8Funcional {
    public static void main(String[] args) {
        // Se crea una función anónima que implementa la interfaz Runnable
//        Runnable viaje = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    // Con getName() se obtiene el nombre del hilo actual.
//                    System.out.println(i + " - " + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());
//            }
//        };

        // Creación de la función anónima con Java 8. Expresión lambda.
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                // Con getName() se obtiene el nombre del hilo actual.
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finalmente me voy de viaje a " + Thread.currentThread().getName());
        };

        // Se crea un hilo nuevo que ejecuta el método run() de la función anónima.
        // Se pasa el nombre del hilo como parámetro al constructor de la clase Thread.
        // Estos hilos se ejecutan en paralelo. Es decir, se ejecutan al mismo tiempo de manera concurrente.
        // Son asíncronos.
        new Thread(viaje, "México").start();
        new Thread(viaje, "España").start();
        new Thread(viaje, "Francia").start();
        new Thread(viaje, "Italia").start();

    }
}
