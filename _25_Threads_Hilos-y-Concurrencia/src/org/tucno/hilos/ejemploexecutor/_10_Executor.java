package org.tucno.hilos.ejemploexecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class _10_Executor {
    // Executor es una interfaz que define un solo método execute(Runnable)
    // ExecutorService es una interfaz que extiende a Executor y define métodos para administrar y controlar el estado de los hilos
    // Executors es una clase que provee métodos estáticos para crear instancias de ExecutorService
    // Executors.newFixedThreadPool(int nThreads) crea un ExecutorService que utiliza un pool de hilos con un número fijo de hilos
    // Executors.newSingleThreadExecutor() crea un ExecutorService que utiliza un único hilo para ejecutar las tareas
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // Se crea un objeto Runnable que se ejecutará en el hilo del ExecutorService
        Runnable tarea = () -> {
            System.out.println("Ejecutando tarea");
            try {
                System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
                // TimeUnit es una clase que define constantes para especificar unidades de tiempo
                // Hace el mismo trabajo que Thread.sleep() pero es más legible
                TimeUnit.SECONDS.sleep(5); // Se simula una tarea que tarda 2 segundos en ejecutarse
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido mientras está dormido, se lanza una excepción
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            System.out.println("Finalizando tarea...");
        };

        // Se envía la tarea al ExecutorService para que la ejecute
        executor.submit(tarea);
        // Se cierra el ExecutorService de forma ordenada (espera a que las tareas se completen)
        executor.shutdown();
        // Se cierra el ExecutorService de forma abrupta (interrumpe las tareas que estén en ejecución)
//        executor.shutdownNow();
        // Espera a que el ExecutorService se cierre (5 segundos como máximo en este caso)
        // Espera a que las tareas se completen o a que se cumpla el tiempo máximo para continuar con la ejecución del hilo principal
        System.out.println("Continuando con la ejecución del hilo principal 1...");
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecución del hilo principal 2...");
    }
}
