package org.tucno.datetime.ejemplos;

import java.time.LocalDate;
import java.time.Period;

public class _08_Period {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2015, 1, 1);
        LocalDate fecha2 = LocalDate.of(2030, 8, 22);

        // Period es una clase que representa un periodo de tiempo entre dos fechas (años, meses y días)
        // con el metodo between podemos obtener el periodo entre dos fechas

        Period periodo = Period.between(fecha1, fecha2);
        System.out.println("Periodo: " + periodo);

        System.out.printf("Periodo entre %s y %s: %d años, %d meses y %d días\n",
                fecha1, fecha2,
                periodo.getYears(), periodo.getMonths(), periodo.getDays());

        // Cambiar la fecha con with
        // Devuelve una copia de la fecha con el periodo indicado
        // se usan los metodos withYear, withMonth y withDayOfMonth para cambiar el año, mes y día respectivamente
        System.out.println("\nFecha1 + 1 año: " + fecha1.withYear(2016));

    }
}
