package org.tucno.hilos.ejemploexecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _16_EjemploScheduleExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        // CountDownLatch es una clase que permite bloquear un hilo hasta que se cumpla una condición
//        CountDownLatch lock = new CountDownLatch(5);

        AtomicInteger contador = new AtomicInteger(5);

        // scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
        // Sirve para ejecutar una tarea periódicamente cada cierto tiempo
        Future<?> future = executor.scheduleAtFixedRate( () -> {
            System.out.println("\nHola mundo tarea antes del sleep...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
//                lock.countDown();
                contador.decrementAndGet();
                System.out.println("Contador: " + contador.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola mundo tarea ...");
        }, 2000, 2000, TimeUnit.MILLISECONDS);

//        TimeUnit.SECONDS.sleep(10);
//        lock.await();
//        future.cancel(true);

        while (contador.get() >= 0) {
            if (contador.get() == 0) {
                future.cancel(true);
                contador.getAndDecrement();
            }
        }

        System.out.println("Alguna otra tarea en el main...");
        executor.shutdown();
    }
}
