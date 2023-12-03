package org.tucno.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class _05_ZonedDateTime {
    public static void main(String[] args) {
        // ZoneDateTime representa una fecha y hora con zona horaria
        LocalDateTime ahoraLocal = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime ahoraNewYork = ZonedDateTime.of(ahoraLocal, newYork);
        System.out.println("Ahora en New York: " + ahoraNewYork);

        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime ahoraMadrid = ahoraNewYork.withZoneSameInstant(madrid);
        System.out.println("Ahora en Madrid: " + ahoraMadrid);

        System.out.println("Fecha de partida en New York: "
                + ahoraNewYork.format(formatter));
        System.out.println("Fecha de llegada a Madrid: "
                + ahoraMadrid.plusHours(8).plusMinutes(15).format(formatter));

        // Podemos crear una fecha y hora con el método parse y pasándole un patrón de formato
        LocalDateTime fechaHora = LocalDateTime.parse("26/12/2020 12:30:00", formatter);
        System.out.println("\nFecha y hora con parse: " + fechaHora.format(formatter));

        ZonedDateTime zoneNY = ZonedDateTime.of(fechaHora, ZoneOffset.of("-04:00"));
        System.out.println("Fecha y hora en New York: " + zoneNY.format(formatter));

        ZonedDateTime zoneMadrid = zoneNY.withZoneSameInstant(ZoneOffset.of("+02:00"));
        System.out.println("Fecha y hora en Madrid: " + zoneMadrid.format(formatter));

        // Listado de zonas horarias
        Set<String> zonas = ZoneId.getAvailableZoneIds();
        System.out.println("\nZonas horarias:");
        zonas.forEach(System.out::println);
    }
}
