package org.tucno.ejemplo;

import org.tucno.pooherencia.*;

public class _04_HerenciaConstructores {
    public static void main(String[] args) {
        /**
         * Las clases hijas llaman implícitamente al constructor de la clase padre
         */
        System.out.println("====== Creando la instancia de la clase Alumno ======");
        Alumno alumno = new Alumno("Juan", "Perez", 13, "Colegio Nacional");
        alumno.setNotaMatematica(15.5);
        alumno.setNotaCastellano(17.5);
        alumno.setNotaHistoria(18.5);
        alumno.setEmail("alumno@gmail.com");

        System.out.println("\n====== Creando la instancia de la clase AlumnoInternacional ======");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional("Peter", "Smith", "USA");
        alumnoInternacional.setEdad(15);
        alumnoInternacional.setInstitucion("Colegio Internacional");
        alumnoInternacional.setNotaMatematica(12.5);
        alumnoInternacional.setNotaCastellano(16.5);
        alumnoInternacional.setNotaHistoria(18);
        alumnoInternacional.setNotaIdiomas(19.5);
        alumnoInternacional.setEmail("alumno.internacional@gmail.com");

        System.out.println("\n======== Creando la instancia de la clase Profesor =========");
        Profesor profesor = new Profesor("Pedro", "Gonzales", "Matemática");
        profesor.setEdad(30);
        profesor.setEmail("profesor@gmail.com");

        System.out.println("\n============ Imprimiendo datos del tipo Alumno =============");
        imprimir(alumno);

        System.out.println("\n====== Imprimiendo datos del tipo AlumnoInternacional ======");
        imprimir(alumnoInternacional);

        System.out.println("\n============ Imprimiendo datos del tipo Profesor ===========");
        imprimir(profesor);

    }

    public static void imprimir(Persona persona) {
        System.out.println("\tImprimiendo datos del tipo Persona: ");
        System.out.println("\t\tNombre: " + persona.getNombre());
        System.out.println("\t\tApellido: " + persona.getApellido());
        System.out.println("\t\tEdad: " + persona.getEdad());
        System.out.println("\t\tEmail: " + persona.getEmail());

        if (persona instanceof Alumno) {
            System.out.println("\tImprimiendo datos del tipo Alumno: ");
            System.out.println("\t\tInstitución: " + ((Alumno) persona).getInstitucion());
            System.out.println("\t\tNota Matemática: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("\t\tNota Castellano: " + ((Alumno) persona).getNotaCastellano());
            System.out.println("\t\tNota Historia: " + ((Alumno) persona).getNotaHistoria());

            if (persona instanceof AlumnoInternacional) {
                System.out.println("\tImprimiendo datos del tipo AlumnoInternacional: ");
                System.out.println("\t\tNota Idiomas: " + ((AlumnoInternacional) persona).getNotaIdiomas());
                System.out.println("\t\tPaís: " + ((AlumnoInternacional) persona).getPais());
            }

            System.out.println("\n\t********* Sobre escritura promedio *********");
            System.out.println("\t\tPromedio: " + ((Alumno) persona).calcularPromedio());
        }

        if (persona instanceof Profesor) {
            System.out.println("\tImprimiendo datos del tipo Profesor: ");
            System.out.println("\t\tAsignatura: " + ((Profesor) persona).getAignatura());
        }

        System.out.println("\n\t********* Sobre escritura de métodos saludar *********");
        System.out.println("\t" + persona.saludar());
    }
}
