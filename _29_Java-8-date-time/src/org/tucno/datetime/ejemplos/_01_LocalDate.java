package org.tucno.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class _01_LocalDate {
    public static void main(String[] args) {
        // LocalDate es una clase inmutable para representar una fecha
        // no tiene hora, minuto, segundo, etc. solo fecha

        // now() - Devuelve la fecha actual del sistema en formato ISO yyyy-MM-dd (2020-12-31)
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Dia del mes: " + fechaActual.getDayOfMonth());
        System.out.println("Numero del Mes: " + fechaActual.getMonthValue());
        System.out.println("Dia de la semana: " + fechaActual.getDayOfWeek());
        System.out.println("Dia de la semana en español: "
                + fechaActual.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.of("es", "PE")));
        System.out.println("Nombre del Mes: " + fechaActual.getMonth());
        System.out.println("Nombre del Mes en español: "
                + fechaActual.getMonth().getDisplayName(TextStyle.FULL, Locale.of("es", "PE")));
        System.out.println("Año: " + fechaActual.getYear());
        System.out.println("Dia del año: " + fechaActual.getDayOfYear());
        System.out.println("Era: " + fechaActual.getEra());

        // of() - Devuelve una fecha en base a los parametros indicados
        // LocalDate.of(año, mes, dia)
        LocalDate fechaEspecifica = LocalDate.of(2020, 12, 31);
        System.out.println("\nfechaEspecifica = " + fechaEspecifica);

        // Otra forma de crear una fecha especifica es usando el enumerado Month
        fechaEspecifica = LocalDate.of(2030, Month.JULY, 26);
        System.out.println("fechaEspecifica = " + fechaEspecifica);

        // parse() - Devuelve una fecha en base a una cadena de texto en formato ISO yyyy-MM-dd (2020-12-31)
        fechaEspecifica = LocalDate.parse("2000-01-01");
        System.out.println("fechaEspecifica = " + fechaEspecifica);

        // plusDays() - Devuelve una fecha con los dias indicados sumados a la fecha actual
        LocalDate diaDeManiana = LocalDate.now().plusDays(1);
        System.out.println("\ndiaDeManiana = " + diaDeManiana);

        // plusWeeks() - Devuelve una fecha con las semanas indicadas sumadas a la fecha actual
        LocalDate semanaQueViene = LocalDate.now().plusWeeks(1);
        System.out.println("semanaQueViene = " + semanaQueViene);

        // plusMonths() - Devuelve una fecha con los meses indicados sumados a la fecha actual
        LocalDate mesQueViene = LocalDate.now().plusMonths(1);
        System.out.println("mesQueViene = " + mesQueViene);

        // plusYears() - Devuelve una fecha con los años indicados sumados a la fecha actual
        LocalDate anioQueViene = LocalDate.now().plusYears(1);
        System.out.println("anioQueViene = " + anioQueViene);

        // minusDays() - Devuelve una fecha con los dias indicados restados a la fecha actual
        LocalDate diaDeAyer = LocalDate.now().minusDays(1);
        System.out.println("\ndiaDeAyer = " + diaDeAyer);

        // minusWeeks() - Devuelve una fecha con las semanas indicadas restadas a la fecha actual
        LocalDate semanaPasada = LocalDate.now().minusWeeks(1);
        System.out.println("semanaPasada = " + semanaPasada);

        // minusMonths() - Devuelve una fecha con los meses indicados restados a la fecha actual
        LocalDate mesPasado = LocalDate.now().minusMonths(1);
        System.out.println("mesPasado = " + mesPasado);

        // minusYears() - Devuelve una fecha con los años indicados restados a la fecha actual
        LocalDate anioPasado = LocalDate.now().minusYears(1);
        System.out.println("anioPasado = " + anioPasado);

        // minus() - Devuelve una fecha con los años, meses y dias indicados restados a la fecha actual
        LocalDate fechaRestada = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("\nfechaRestada = " + fechaRestada);

        // getDayOfWeek() - Devuelve el dia de la semana de la fecha indicada
        DayOfWeek diaDeLaSemana = LocalDate.parse("2020-12-25").getDayOfWeek();
        System.out.println("\ndiaDeLaSemana = " + diaDeLaSemana);

        DayOfWeek hoy = LocalDate.now().getDayOfWeek();
        System.out.println("hoy = " + hoy);

        // getDayOfMonth() - Devuelve el dia del mes de la fecha indicada
        int mesActual = LocalDate.now().getDayOfMonth();
        System.out.println("mesActual = " + mesActual);

        // getDayOfYear() - Devuelve el dia del año de la fecha indicada
        int diaDelAnio = LocalDate.now().getDayOfYear();
        System.out.println("diaDelAnio = " + diaDelAnio);

        // isLeapYear() - Devuelve true si el año de la fecha indicada es bisiesto
        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("\nesBisiesto = " + esBisiesto);

        // isBefore() - Devuelve true si la fecha indicada es anterior a la fecha actual
        boolean esAntes = LocalDate.parse("2020-12-25").isBefore(LocalDate.now());
        System.out.println("\nesAntes = " + esAntes);

        // isAfter() - Devuelve true si la fecha indicada es posterior a la fecha actual
        boolean esDespues = LocalDate.parse("2020-12-25").isAfter(LocalDate.now());
        System.out.println("esDespues = " + esDespues);

        // isEqual() - Devuelve true si la fecha indicada es igual a la fecha actual
        boolean esIgual = LocalDate.now().isEqual(LocalDate.now());
        System.out.println("esIgual = " + esIgual);
    }
}
