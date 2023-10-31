package org.tucno.hilos.ejemplotimer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class _08_EjemploAgendarTareaTimer {
    public static void main(String[] args) {
        // Timer es una clase que permite agendar tareas para que se ejecuten en un momento determinado.
        // Sirve para ejecutar tareas de forma periódica.
        Timer timer = new Timer();

        // El método schedule() permite agendar una tarea para que se ejecute en un momento determinado.
        // Se implementa la clase TimerTask, que es una clase abstracta que implementa la interfaz Runnable.
        // En este caso, se crea una clase anónima que hereda de TimerTask.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + "\nnombre del hilo: " + Thread.currentThread().getName());
                // El método cancel() permite cancelar la tarea. En este caso, se cancela la tarea después de 5 segundos.
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agendando tarea para 5 segundos después...");
    }
}
