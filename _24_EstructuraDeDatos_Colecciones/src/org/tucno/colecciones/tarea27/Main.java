package org.tucno.colecciones.tarea27;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("EEE dd MMM yyyy HH:mm 'hrs'", Locale.forLanguageTag("es-ES"));
        List<Vuelo> vuelos = new ArrayList<>();

        vuelos.add(new Vuelo("AAL 933", "New York", "Santiago", df.parse("Lun 29 Ago 2021 05:39 hrs"), 62));
        vuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", df.parse("Lun 31 Ago 2021 04:45 hrs"), 47));
        vuelos.add(new Vuelo("SKU 621", "Rio Janeiro", "Santiago", df.parse("Lun 30 Ago 2021 16:00 hrs"), 52));
        vuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", df.parse("Lun 29 Ago 2021 13:22 hrs"), 59));
        vuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", df.parse("Lun 31 Ago 2021 14:05 hrs"), 25));
        vuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", df.parse("Lun 31 Ago 2021 05:20 hrs"), 29));
        vuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago", df.parse("Lun 30 Ago 2021 08:45 hrs"), 55));
        vuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", df.parse("Lun 29 Ago 2021 07:41 hrs"), 51));
        vuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", df.parse("Lun 30 Ago 2021 10:35 hrs"), 48));
        vuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", df.parse("Lun 29 Ago 2021 09:14 hrs"), 59));
        vuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", df.parse("Lun 31 Ago 2021 08:33 hrs"), 31));
        vuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", df.parse("Lun 31 Ago 2021 15:15 hrs"), 29));
        vuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", df.parse("Lun 30 Ago 2021 08:14 hrs"), 47));
        vuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", df.parse("Lun 29 Ago 2021 22:53 hrs"), 60));
        vuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", df.parse("Lun 31 Ago 2021 09:57 hrs"), 32));
        vuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago", df.parse("Lun 31 Ago 2021 04:00 hrs"), 35));
        vuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", df.parse("Lun 29 Ago 2021 07:45 hrs"), 61));
        vuelos.add(new Vuelo("AAL 945", "Dallas-Fort", "Santiago", df.parse("Lun 30 Ago 2021 07:12 hrs"), 58));
        vuelos.add(new Vuelo("LAT 501", "París", "Santiago", df.parse("Lun 29 Ago 2021 18:29 hrs"), 49));
        vuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", df.parse("Lun 30 Ago 2021 15:45 hrs"), 39));

        // Ordenar por llegada de forma ascendente
        vuelos.sort((a, b) -> b.getFechaLlegada().compareTo(a.getFechaLlegada()));
        vuelos.forEach(v -> System.out.println(v));

        // Obtener el último vuelo en llegar
        Vuelo ultimoVuelo = vuelos.get(0);
        System.out.println("\nÚltimo vuelo en llegar es " + ultimoVuelo.getNombre() + " que viene desde " + ultimoVuelo.getOrigen() + " y llega a " + ultimoVuelo.getDestino() + " a las " + df.format(ultimoVuelo.getFechaLlegada()));

        // Obtener el vuelo que tiene menor número de pasajeros
        Vuelo menorNumeroPasajeros = vuelos.get(0);

        for ( Vuelo vuelo : vuelos ) {
            if ( vuelo.getNumeroPasajeros() < vuelos.get(0).getNumeroPasajeros() ) {
                menorNumeroPasajeros = vuelo;
            }
        }
        System.out.println("\nEl vuelo con menor número de pasajeros es " + menorNumeroPasajeros.getNombre() + " con " + menorNumeroPasajeros.getNumeroPasajeros() + " pasajeros");

    }
}
