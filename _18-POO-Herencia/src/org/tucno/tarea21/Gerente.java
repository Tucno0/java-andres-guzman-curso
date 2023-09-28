package org.tucno.tarea21;

public class Gerente extends Empleado{
    private Double presupuesto;

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, Double remuneracion, int empleadoOld, Double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion, empleadoOld);
        this.presupuesto = presupuesto;
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    // Sobre-escritura de métodos
    @Override
    public String toString() {
        return super.toString() +  // Llamada al método toString() de la clase padre
               "Presupuesto: " + this.presupuesto + "\n";
    }
}
