package org.tucno.datetime.ejemplos;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class _07_DurationInstant {
    public static void main(String[] args) {
        // Instant es una clase que representa un instante de tiempo en el eje de tiempo de Unix
        // es decir, el número de segundos y nanosegundos transcurridos desde el 1 de enero de 1970

        Instant inicio = Instant.now();
        System.out.println("Inicio: " + inicio);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Instant fin = Instant.now();
        System.out.println("Fin: " + fin);

        Duration duracion = Duration.between(inicio, fin);
        System.out.println("Duración: " + duracion);
    }



}
