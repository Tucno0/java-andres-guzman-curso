package org.tucno.datetime.tareas;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Tarea35 {
    public static void main(String[] args) {
        // Para esta tarea se pide ingresar una fecha de nacimiento en formato string, convertirla a una fecha del tipo LocalDate y calcular la edad de la persona de acuerdo a la fecha actual.
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese su fecha de nacimiento (yyyy-mm-dd): ");
            String fecha = scanner.nextLine();

            LocalDate fechaNacimiento = LocalDate.parse(fecha);
            LocalDate fechaActual = LocalDate.now();

            Period edad = Period.between(fechaNacimiento, fechaActual);
            int edadAnios = edad.getYears();

            System.out.println("Tu edad es: " + edadAnios + " años");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            main(null);
        }
    }
}
