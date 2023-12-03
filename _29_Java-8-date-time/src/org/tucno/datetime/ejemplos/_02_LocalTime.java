package org.tucno.datetime.ejemplos;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class _02_LocalTime {
    public static void main(String[] args) {
        // LocalTime representa una hora del día, sin fecha y sin zona horaria
        LocalTime ahora = LocalTime.now();
        System.out.println("Ahora: " + ahora);
        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Segundos: " + ahora.getSecond());
        System.out.println("Nano segundos: " + ahora.getNano());

        // También podemos crear un objeto LocalTime con una hora específica con el método of
        LocalTime hora = LocalTime.of(12, 30);
        System.out.println("\nHoraOf: " + hora);

        // También podemos crear un objeto LocalTime con una hora específica con el método parse
        LocalTime hora2 = LocalTime.parse("10:30");
        System.out.println("HoraParse: " + hora2);

        LocalTime hora3 = LocalTime.parse("10:30:25");
        System.out.println("HoraParse: " + hora3);

        // Podemos sumar y restar horas, minutos, segundos y nanosegundos
        LocalTime enUnaHora = ahora.plusHours(1);
        System.out.println("\nEn una hora: " + enUnaHora);

        LocalTime enUnaHora2 = ahora.plusHours(1).plusMinutes(30);
        System.out.println("En una hora y media: " + enUnaHora2);

        LocalTime enUnaHora3 = LocalTime.of(12, 30).plus(1, ChronoUnit.HOURS);
        System.out.println("En una hora: " + enUnaHora3);

        // Podemos comparar dos horas
        System.out.println("\n¿Es ahora antes de enUnaHora? " + ahora.isBefore(enUnaHora));
        System.out.println("¿Es ahora después de enUnaHora? " + ahora.isAfter(enUnaHora));
        System.out.println("¿Es ahora igual a enUnaHora? " + ahora.equals(enUnaHora));


    }
}
