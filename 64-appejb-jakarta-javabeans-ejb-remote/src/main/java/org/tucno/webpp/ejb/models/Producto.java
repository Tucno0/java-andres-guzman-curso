package org.tucno.webpp.ejb.models;

import java.io.Serializable;

public class Producto implements Serializable {
    // SerialVersionUID: Identificador único de la clase para la serialización
    // esto sirve para que cuando necesitemos usar esta clase desde un cliente remoto
    static final long serialVersionUID = 1849465484L;

    private String nombre;

    public Producto() {
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
