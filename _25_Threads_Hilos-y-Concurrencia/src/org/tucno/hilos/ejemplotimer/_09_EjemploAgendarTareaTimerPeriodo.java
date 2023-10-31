package org.tucno.hilos.ejemplotimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class _09_EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {
        // La clase Toolkit permite obtener información sobre el entorno de la aplicación.
        // Se puede utilizar para obtener información sobre la pantalla, el ratón, el teclado, etc.
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // La clase Timer permite agendar tareas para que se ejecuten en un momento determinado.
        Timer timer = new Timer();

        // AtomicInteger es una clase que permite crear un entero que se puede modificar de forma atómica.
        // Se puede utilizar dentro de una clase anónima.
        AtomicInteger contadorAtomic = new AtomicInteger(5);

        // El método schedule() permite agendar una tarea para que se ejecute en un momento determinado.
        // El primer parámetro es la tarea a ejecutar.
        // El segundo parámetro es el tiempo que debe esperar el hilo para ejecutar la tarea.
        // El tercer parámetro es el periodo de tiempo que debe esperar el hilo para volver a ejecutar la tarea.
        // Si la tarea se ejecuta en un tiempo mayor que el periodo, el hilo espera a que termine la tarea para volver a ejecutarla.
        timer.schedule(new TimerTask() {
//            int contador = 3; // Se usa para contar las veces que se ejecuta la tarea y para controlar la cancelación de la tarea.
            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();

                if (i > 0) {
                    toolkit.beep(); // Emite un sonido. Se puede utilizar para avisar al usuario de que se ha ejecutado una tarea.
                    System.out.println("Tarea periódica " + i + " realizada en: " + new Date() +
                            "\nnombre del hilo: " + Thread.currentThread().getName());
//                    contador--;
                } else {
                    System.out.println("Finaliza la tarea periódica");
                    timer.cancel();
                }
            }
        }, 0, 3000);

        System.out.println("Agendando tarea para 3 segundos más...");
    }
}
