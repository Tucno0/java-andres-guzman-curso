package org.tucno.ejemplo;

import org.tucno.pooherencia.Alumno;
import org.tucno.pooherencia.AlumnoInternacional;
import org.tucno.pooherencia.Profesor;

public class _03_Herencia2 {
    public static void main(String[] args) {
        /**
         * Las clases hijas llaman implícitamente al constructor de la clase padre
         */
        System.out.println("====== Creando la instancia de la clase Alumno ======");
        Alumno alumno = new Alumno();
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setInstitucion("Colegio Nacional");
        alumno.setNotaMatematica(15.5);
        alumno.setNotaCastellano(17.5);
        alumno.setNotaHistoria(18.5);

        System.out.println("\n====== Creando la instancia de la clase AlumnoInternacional ======");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional();
        alumnoInternacional.setNombre("Peter");
        alumnoInternacional.setApellido("Smith");
        alumnoInternacional.setEdad(20);
        alumnoInternacional.setPais("USA");
        alumnoInternacional.setInstitucion("Colegio Internacional");
        alumnoInternacional.setNotaMatematica(12.5);
        alumnoInternacional.setNotaCastellano(16.5);
        alumnoInternacional.setNotaHistoria(18);

        System.out.println("\n====== Creando la instancia de la clase Profesor ======");
        Profesor profesor = new Profesor();
        profesor.setNombre("Pedro");
        profesor.setApellido("Gonzales");
        profesor.setEdad(30);
        profesor.setEmail("example2@gmail.com");
        profesor.setAignatura("Matemática");

        System.out.println("\nAlumno: " + alumno.getNombre() + " " + alumno.getApellido());

        System.out.println(
            "Alumno Internacional: " +
            alumnoInternacional.getNombre() + " " +
            alumnoInternacional.getApellido() + " - " +
            alumnoInternacional.getInstitucion() + " - " +
            alumnoInternacional.getPais()
        );

        System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + " - " + profesor.getAignatura());

        System.out.println("\n====== Imprimiendo la jerarquía de clases ======");
        // Imprimir la jerarquía de clases
        Class clase = alumnoInternacional.getClass();
        while ( clase.getSuperclass() != null ) {
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();
            System.out.println(hija + " es hija de " + padre);
            clase = clase.getSuperclass();
        }
    }
}
