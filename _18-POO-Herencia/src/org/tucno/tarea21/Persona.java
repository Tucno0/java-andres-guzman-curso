package org.tucno.tarea21;

public class Persona {
    // Atributos
    private String nombre;
    private String apellido;
    private String numeroFiscal;
    private String direccion;

    // Constructor
    public Persona(String nombre, String apellido, String numeroFiscal, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroFiscal = numeroFiscal;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    // Sobre-escritura de métodos
    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
               "Apellido: " + this.apellido + "\n" +
               "Número Fiscal: " + this.numeroFiscal + "\n" +
               "Dirección: " + this.direccion + "\n";
    }
}
