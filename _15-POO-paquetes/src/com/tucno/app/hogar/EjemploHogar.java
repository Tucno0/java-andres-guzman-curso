package com.tucno.app.hogar;

import com.tucno.app.jardin.Perro;

public class EjemploHogar {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro perro = new Perro();

        String saludo = Persona.saludar();
        System.out.println("saludo = " + saludo);
    }
}
