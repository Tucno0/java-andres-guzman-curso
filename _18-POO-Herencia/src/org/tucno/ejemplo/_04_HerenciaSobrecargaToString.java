package org.tucno.ejemplo;

import org.tucno.pooherencia.*;

public class _04_HerenciaSobrecargaToString {
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
        System.out.println(persona);
    }

    /**
     * Al poner final a una clase no se puede heredar de ella (no se puede crear clases hijas)
     * Al poner final a un método no se puede sobreescribir dicho método
     */
}
