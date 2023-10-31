package org.tucno.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class _11_ExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

//        Runnable tarea = () -> { // Runnable no permite devolver un resultado
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

        Future<String> resultado = executor.submit(tarea); // Devuelve un Future<?> que permite obtener el resultado de la tarea
        executor.shutdown();

        System.out.println("Continuando con la ejecución del hilo principal...");

        while (!resultado.isDone()) {
            System.out.println("La tarea no ha finalizado, esperando 1 segundo...");
            TimeUnit.MILLISECONDS.sleep(500);
        }

        System.out.println(resultado.isDone()); // isDone() devuelve true si la tarea ha finalizado
//        System.out.println(resultado.get()); // get() es un método bloqueante que devuelve el resultado de la tarea
        System.out.println(resultado.get(5, TimeUnit.SECONDS)); // Después de 2 segundos, se lanza una excepción TimeoutException si la tarea no ha finalizado
        System.out.println("Finaliza la tarea: " + resultado.isDone());
    }
}
