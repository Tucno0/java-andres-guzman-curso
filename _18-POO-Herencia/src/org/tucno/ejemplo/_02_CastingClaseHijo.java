package org.tucno.ejemplo;

import org.tucno.pooherencia.Alumno;
import org.tucno.pooherencia.Persona;
import org.tucno.pooherencia.Profesor;

public class _02_CastingClaseHijo {
    public static void main(String[] args) {
        Persona alumno = new Alumno(); // Polimorfismo - Upcasting
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setEdad(20);
        alumno.setEmail("example@gmail.com");

        // Ya no se puede acceder a los atributos de la clase Alumno
        // alumno.setInstitucion("Colegio Nacional");
        // Para acceder a los atributos de la clase Alumno se debe hacer un Downcasting
         ((Alumno) alumno).setInstitucion("Colegio Nacional");

        Profesor profesor = new Profesor();
        profesor.setNombre("Pedro");
        profesor.setApellido("Gonzales");
        profesor.setEdad(30);
        profesor.setEmail("example2@gmail.com");
        profesor.setAignatura("Matemática");

        System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " - " + ((Alumno) alumno).getInstitucion());
        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + " - " + profesor.getAignatura());
    }
}
