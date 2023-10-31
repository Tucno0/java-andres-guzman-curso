package org.tucno.hilos.ejemploexecutor;

import org.tucno.hilos.ejemplosync.Panaderia;
import org.tucno.hilos.ejemplosync.runnable.Consumidor;
import org.tucno.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;
public class _14_EjemploExecutorProductor {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        // minimo 2 hilos para ejecutar tareas en paralelo, porque hay 2 hilos sincronizados en la panaderia

        System.out.println("Tamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        Panaderia p = new Panaderia();
        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);

        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);

        System.out.println("\nTamaño del pool: " + executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + executor.getQueue().size());

        executor.shutdown();

        System.out.println("\nContinuando con la ejecución del hilo principal...");

    }
}
