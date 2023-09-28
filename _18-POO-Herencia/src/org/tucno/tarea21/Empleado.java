package org.tucno.tarea21;

public class Empleado extends Persona{
    // Atributos
    private Double remuneracion;
    private int empleadoOld;

    // Constructor
    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, Double remuneracion, int empleadoOld) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoOld = empleadoOld;
    }

    // Getters y Setters

    public Double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(Double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public int getEmpleadoOld() {
        return empleadoOld;
    }

    // Métodos
    public void aumentarSueldo(Double porcentaje) {
        this.remuneracion += this.remuneracion * porcentaje / 100;
    }

    // Sobre-escritura de métodos
    @Override
    public String toString() {
        return super.toString() +  // Llamada al método toString() de la clase padre
               "Remuneración: " + this.remuneracion + "\n" +
               "Antigüedad: " + this.empleadoOld + "\n";
    }
}
