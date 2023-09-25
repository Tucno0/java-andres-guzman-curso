package org.tucno.pooherencia;

public class Profesor extends Persona {
    private String aignatura;

    // Constructor
    public Profesor() {
        System.out.println("Profesor: Inicializando constructor");
    }
    public Profesor(String nombre, String apellido) {
        super(nombre, apellido);
    }
    public Profesor(String nombre, String apellido, String aignatura) {
        super(nombre, apellido);
        this.aignatura = aignatura;
    }

    // Getters y Setters
    public String getAignatura() {
        return aignatura;
    }

    public void setAignatura(String aignatura) {
        this.aignatura = aignatura;
    }

    // Sobre escritura de métodos

    @Override
    public String saludar() {
        return "Buenos dias, soy el profesor " + this.getNombre() + " " + this.getApellido() + " y enseño " + this.aignatura;
    }

    @Override
    public String toString() {
        return  super.toString() + '\'' +
                "\naignatura = '" + aignatura;
    }
}
