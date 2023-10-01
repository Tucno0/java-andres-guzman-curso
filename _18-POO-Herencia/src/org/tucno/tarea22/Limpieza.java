package org.tucno.tarea22;

public class Limpieza extends Producto{
    private String componentes;
    private double litros;

    public Limpieza() {
    }

    public Limpieza(String nombre, double precio, String componentes, double litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nComponentes: " + componentes +
                "\nLitros: " + litros + "L";
    }
}
