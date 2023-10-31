package org.tucno.hilos.ejemploexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _15_EjemploScheduleExecutorService {
    public static void main(String[] args) {
        /**
         * ScheduledExecutorService es una subinterfaz de ExecutorService que permite programar la ejecución de tareas
         * para que se ejecuten en un momento determinado o periódicamente. Para ello, dispone de los métodos:
         * - schedule(Runnable command, long delay, TimeUnit unit) -> Ejecuta la tarea una vez transcurrido el tiempo indicado
         * - schedule(Callable<V> callable, long delay, TimeUnit unit) -> Ejecuta la tarea una vez transcurrido el tiempo indicado
         * - scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) -> Ejecuta la tarea periódicamente
         * - scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) -> Ejecuta la tarea periódicamente
         */

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        executor.schedule( () -> {
            System.out.println("Hola mundo tarea antes del sleep...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea ...");
        }, 2000, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
