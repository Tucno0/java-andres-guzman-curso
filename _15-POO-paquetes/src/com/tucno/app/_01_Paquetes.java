package com.tucno.app;

//import com.tucno.app.hogar.Gato;
//import com.tucno.app.hogar.Persona;

import com.tucno.app.hogar.*; // Importa todas las clases del paquete

public class _01_Paquetes {
    public static void main(String[] args) {

        // Primer forma de importar una clase
//        com.tucno.app.hogar.Persona persona = new com.tucno.app.hogar.Persona();

        // Segunda forma de importar una clase
        Persona persona = new Persona();
        persona.nombre = "Juan";
        System.out.println(persona.nombre);

        Gato gato = new Gato();
    }
}
