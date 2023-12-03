package org.tucno.datetime.ejemplos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class _03_DateTimeFormatter {
    public static void main(String[] args) {
        // DateTimeFormatter es una clase que nos permite formatear fechas y horas en un formato específico
        // Podemos crear un objeto DateTimeFormatter con el método ofPattern y pasándole un patrón de formato
        // El patrón de formato es una cadena de caracteres que nos permite indicar cómo queremos que se muestre la fecha u hora
        // Por ejemplo, para mostrar la fecha en formato dd/MM/yyyy, el patrón sería "dd/MM/yyyy"
        // Para mostrar la hora en formato HH:mm:ss, el patrón sería "HH:mm:ss"
        // Para mostrar la fecha y la hora en formato dd/MM/yyyy HH:mm:ss, el patrón sería "dd/MM/yyyy HH:mm:ss"
        // DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // HH para 24 horas, hh para 12 horas; a para AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");

        LocalTime ahora = LocalTime.now();
        System.out.println("Hora: " + ahora);

        // Podemos formatear una hora con el método format
        String horaFormateada = formatter.format(ahora); // ó ahora.format(formatter);
        System.out.println("Hora formateada: " + horaFormateada);

        // Podemos crear un objeto LocalTime a partir de una cadena de caracteres con el método parse
        LocalTime horaParseada = LocalTime.parse("10:30:25");
        System.out.println("Hora parseada: " + horaParseada);
        String horaParseadaFormateada = formatter.format(horaParseada);
        System.out.println("Hora parseada formateada: " + horaParseadaFormateada);

        // Hora máxima y mínima del día
        LocalTime max = LocalTime.MAX;
        System.out.println("\nHora máxima: " + max);
        String maxFormateada = formatter.format(max);
        System.out.println("Hora máxima formateada: " + maxFormateada);

        LocalTime min = LocalTime.MIN;
        System.out.println("Hora mínima: " + min);
        String minFormateada = formatter.format(min);
        System.out.println("Hora mínima formateada: " + minFormateada);

        LocalTime mediodia = LocalTime.NOON;
        System.out.println("Mediodía: " + mediodia);
        String mediodiaFormateada = formatter.format(mediodia);
        System.out.println("Mediodía formateada: " + mediodiaFormateada);

        LocalTime medianoche = LocalTime.MIDNIGHT;
        System.out.println("Medianoche: " + medianoche);
        String medianocheFormateada = formatter.format(medianoche);
        System.out.println("Medianoche formateada: " + medianocheFormateada);
    }
}
