package com.tucno.app.jardin;

//import com.tucno.app.hogar.Gato;
//import com.tucno.app.hogar.Persona;

import com.tucno.app.hogar.*; // Importa todas las clases del paquete

public class EjemploPaquetes {
    public static void main(String[] args) {

        // Primer forma de importar una clase
//        com.tucno.app.hogar.Persona persona = new com.tucno.app.hogar.Persona();

        // Segunda forma de importar una clase
        Persona persona = new Persona();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        System.out.println(persona.getNombre());

        Perro perro = new Perro();
        perro.nombre = "Firulais";
        perro.raza = "Bulldog";

        String jugada = perro.jugar(persona);
        System.out.println("jugada = " + jugada);
    }
}
