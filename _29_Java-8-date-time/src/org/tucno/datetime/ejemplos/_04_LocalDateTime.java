package org.tucno.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class _04_LocalDateTime {
    public static void main(String[] args) {
        // LocalDateTime representa una fecha y hora, sin zona horaria
        // El método now() nos devuelve la fecha y hora actual
        // El método of() nos permite crear un objeto LocalDateTime con una fecha y hora específica
        // El método parse() nos permite crear un objeto LocalDateTime a partir de una cadena de caracteres
        // El método plus() nos permite sumarle horas, minutos, segundos y nanosegundos
        // El método minus() nos permite restarle horas, minutos, segundos y nanosegundos
        // El método isBefore() nos permite comparar si una fecha y hora es anterior a otra
        // El método isAfter() nos permite comparar si una fecha y hora es posterior a otra
        // El método equals() nos permite comparar si una fecha y hora es igual a otra
        // El método getYear() nos devuelve el año
        // El método getMonth() nos devuelve el mes
        // El método getDayOfMonth() nos devuelve el día del mes
        // El método getDayOfYear() nos devuelve el día del año
        // El método getDayOfWeek() nos devuelve el día de la semana
        // El método getHour() nos devuelve la hora
        // El método getMinute() nos devuelve los minutos
        // El método getSecond() nos devuelve los segundos
        // El método getNano() nos devuelve los nanosegundos
        // El método toLocalDate() nos devuelve un objeto LocalDate con la fecha
        // El método toLocalTime() nos devuelve un objeto LocalTime con la hora


        System.out.println("CREACIÓN DE FECHAS Y HORAS\n");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Ahora: " + ahora);

        LocalDateTime fechaHora = LocalDateTime.of(2020, 12, 25, 12, 30);
        System.out.println("Fecha y hora con of: " + fechaHora);

        LocalDateTime fechaHora2 = LocalDateTime.parse("2020-12-25T12:30:00");
        System.out.println("Fecha y hora con parse: " + fechaHora2);

        Month mes = ahora.getMonth();
        System.out.println("Mes: " + mes);

        int diaDelMes = ahora.getDayOfMonth();
        System.out.println("Día del mes: " + diaDelMes);

        int diaDelAnio = ahora.getDayOfYear();
        System.out.println("Día del año: " + diaDelAnio);

        int diaDeLaSemana = ahora.getDayOfWeek().getValue();
        System.out.println("Día de la semana: " + diaDeLaSemana);

        int hora = ahora.getHour();
        System.out.println("Hora: " + hora);

        int minutos = ahora.getMinute();
        System.out.println("Minutos: " + minutos);

        int segundos = ahora.getSecond();
        System.out.println("Segundos: " + segundos);

        int nanosegundos = ahora.getNano();
        System.out.println("Nanosegundos: " + nanosegundos);

        LocalDateTime fecha = ahora.toLocalDate().atStartOfDay();
        System.out.println("Fecha: " + fecha);


        System.out.println("\n\nSUMA DE HORAS, SEMANAS, MESES, AÑOS, ETC.\n");
        LocalDateTime enUnaHora = ahora.plusHours(1);
        System.out.println("En una hora: " + enUnaHora);

        LocalDateTime enUnaHora2 = ahora.plusHours(1).plusMinutes(30);
        System.out.println("En una hora y media: " + enUnaHora2);

        LocalDateTime enUnaHora3 = LocalDateTime.of(2020, 12, 25, 12, 30).plusHours(1);
        System.out.println("En una hora: " + enUnaHora3);

        LocalDateTime enUnDia = ahora.plusDays(1);
        System.out.println("\nEn un día: " + enUnDia);

        LocalDateTime enUnDia2 = ahora.plus(1, ChronoUnit.DAYS);
        System.out.println("En un día: " + enUnDia2);

        LocalDateTime enUnaSemana = ahora.plusWeeks(1);
        System.out.println("\nEn una semana: " + enUnaSemana);

        LocalDateTime enUnaSemana2 = ahora.plus(1, ChronoUnit.WEEKS);
        System.out.println("En una semana: " + enUnaSemana2);

        LocalDateTime enUnMes = ahora.plusMonths(1);
        System.out.println("\nEn un mes: " + enUnMes);

        LocalDateTime enUnMes2 = ahora.plus(1, ChronoUnit.MONTHS);
        System.out.println("En un mes: " + enUnMes2);

        LocalDateTime enUnAnio = ahora.plusYears(1);
        System.out.println("\nEn un año: " + enUnAnio);

        LocalDateTime enUnAnio2 = ahora.plus(1, ChronoUnit.YEARS);
        System.out.println("En un año: " + enUnAnio2);

        LocalDateTime enUnaDecada = ahora.plus(1, ChronoUnit.DECADES);
        System.out.println("\nEn una década: " + enUnaDecada);

        LocalDateTime enUnSiglo = ahora.plus(1, ChronoUnit.CENTURIES);
        System.out.println("\nEn un siglo: " + enUnSiglo);

        LocalDateTime enUnMilenio = ahora.plus(1, ChronoUnit.MILLENNIA);
        System.out.println("\nEn un milenio: " + enUnMilenio);

        LocalDateTime enUnMilenio2 = ahora.plusYears(1000);
        System.out.println("En un milenio: " + enUnMilenio2);


        System.out.println("\n\nRESTA DE HORAS, SEMANAS, MESES, AÑOS, ETC.\n");
        LocalDateTime haceUnaHora = ahora.minusHours(1);
        System.out.println("Hace una hora: " + haceUnaHora);

        LocalDateTime haceUnaHora2 = ahora.minusHours(1).minusMinutes(30);
        System.out.println("Hace una hora y media: " + haceUnaHora2);

        LocalDateTime haceUnDia = ahora.minus(1, ChronoUnit.DAYS);
        System.out.println("Hace un día: " + haceUnDia);

        LocalDateTime haceUnaSemana = ahora.minusWeeks(1);
        System.out.println("Hace una semana: " + haceUnaSemana);

        LocalDateTime haceUnMes = ahora.minusMonths(1);
        System.out.println("Hace un mes: " + haceUnMes);

        LocalDateTime haceUnAnio = ahora.minusYears(1);
        System.out.println("Hace un año: " + haceUnAnio);

        LocalDateTime haceUnaDecada = ahora.minus(1, ChronoUnit.DECADES);
        System.out.println("Hace una década: " + haceUnaDecada);

        LocalDateTime haceUnSiglo = ahora.minus(1, ChronoUnit.CENTURIES);
        System.out.println("Hace un siglo: " + haceUnSiglo);

        LocalDateTime haceUnMilenio = ahora.minus(1, ChronoUnit.MILLENNIA);
        System.out.println("Hace un milenio: " + haceUnMilenio);


        System.out.println("\n\nFORMATO DE FECHAS Y HORAS\n");
        String ahoraFormateada = ahora.format(DateTimeFormatter.ISO_DATE);
        System.out.println("Ahora formateada: " + ahoraFormateada);

        String ahoraFormateada2 = ahora.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("Ahora formateada: " + ahoraFormateada2);

        String formatoConPatron = ahora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a"));
        System.out.println("Fecha y hora formateada: " + formatoConPatron);
    }
}
