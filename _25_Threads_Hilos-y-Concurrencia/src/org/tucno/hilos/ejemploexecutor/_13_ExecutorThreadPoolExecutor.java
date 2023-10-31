package org.tucno.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class _13_ExecutorThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        // ThreadPoolExecutor es una implementación de ExecutorService que permite crear un pool de hilos
        // y reutilizarlos para ejecutar tareas en paralelo
        // Se pueden crear hilos de forma manual, pero es más sencillo utilizar un ExecutorService

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool: " + executor.getPoolSize()); // getPoolSize() devuelve el tamaño del pool
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size()); // getQueue() devuelve la cola de tareas

        Callable<String> tarea = () -> { // Callable permite devolver un resultado
            System.out.println("Ejecutando tarea");
            try {
                System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3); // Se simula una tarea que tarda 2 segundos en ejecutarse
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }

            System.out.println("Finalizando tarea...");
            return "Resultado de la tarea"; // Se devuelve un resultado (Callable)
        };

        Callable<Integer> tarea2 = () -> {
            System.out.println("Ejecutando tarea 3");
            TimeUnit.SECONDS.sleep(3); // Se simula una tarea que tarda 2 segundos en ejecutarse
            return 10;
        };

        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("\nTamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();

        System.out.println("\nContinuando con la ejecución del hilo principal...");

        while (!resultado.isDone() && !resultado2.isDone() && !resultado3.isDone()) {
            System.out.println(String.format("Tarea 1: %s, Tarea 2: %s, Tarea 3: %s",
                    resultado.isDone() ? "Finalizada" : "En proceso",
                    resultado2.isDone() ? "Finalizada" : "En proceso",
                    resultado3.isDone() ? "Finalizada" : "En proceso"));

            TimeUnit.MILLISECONDS.sleep(1000);
        }

        System.out.println("\nObteniendo el resultado 1 de la tarea : " + resultado.get());
        System.out.println("Finaliza la tarea 1: " + resultado.isDone());

        System.out.println("\nObteniendo el resultado 2 de la tarea : " + resultado2.get());
        System.out.println("Finaliza la tarea: 2 " + resultado2.isDone());

        System.out.println("\nObteniendo el resultado 3 de la tarea : " + resultado3.get());
        System.out.println("Finaliza la tarea 3: " + resultado3.isDone());
    }
}
