package org.tucno.datetime.ejemplos;

import java.time.Duration;
import java.time.LocalDateTime;

public class _06_Duration {
    public static void main(String[] args) {
        LocalDateTime inicio = LocalDateTime.now();
        LocalDateTime fin = LocalDateTime.now().plusDays(1).plusHours(1).plusMinutes(30).plusSeconds(15);

        System.out.println("Inicio: " + inicio);
        System.out.println("Fin: " + fin);

        // Duration es una clase que representa una duración de tiempo entre dos instantes
        // con el metodo between podemos obtener la duración entre dos instantes de tiempo

        Duration duracion = Duration.between(inicio, fin);
        System.out.println("Duración: " + duracion);
        System.out.println("Duración en horas: " + duracion.toHours());
        System.out.println("Duración en minutos: " + duracion.toMinutes());
        System.out.println("Duración en segundos: " + duracion.getSeconds());
        System.out.println("Duración en nanosegundos: " + duracion.toNanos());

        // Podemos sumar y restar duraciones a un instante de tiempo
        System.out.println("\nInicio + 1 hora: " + inicio.plusHours(1));
        System.out.println("Inicio + 1 hora: " + inicio.plus(duracion));
    }
}
