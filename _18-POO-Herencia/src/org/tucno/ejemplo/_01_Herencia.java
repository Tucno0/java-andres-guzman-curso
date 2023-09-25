package org.tucno.ejemplo;

import org.tucno.pooherencia.*;

public class _01_Herencia {
    public static void main(String[] args) {
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setEdad(20);
        alumno.setEmail("example@gmail.com");

        Profesor profesor = new Profesor();
        profesor.setNombre("Pedro");
        profesor.setApellido("Gonzales");
        profesor.setEdad(30);
        profesor.setEmail("example2@gmail.com");
        profesor.setAignatura("Matemática");

        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + " - " + profesor.getAignatura());
    }
}
