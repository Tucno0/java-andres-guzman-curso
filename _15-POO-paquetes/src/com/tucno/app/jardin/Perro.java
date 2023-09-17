package com.tucno.app.jardin;

import com.tucno.app.hogar.Persona;

public class Perro {

    // Los atributos de la clase Perro tienen un modificador de acceso por defecto
    // Esto significa que solo pueden ser accedidos desde el mismo paquete
    // Si se desea acceder a estos atributos desde otro paquete, se debe agregar el modificador de acceso public
    protected String nombre;
    protected String raza;

    String jugar(Persona persona) {
        return persona.lanzarPelota();
    }
}
