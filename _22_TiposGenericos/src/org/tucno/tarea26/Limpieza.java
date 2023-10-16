package org.tucno.tarea26;

public class Limpieza extends Producto{
    private String componentes;
    private double litros;

    public Limpieza(String nombre, double precio, String componentes, double litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() {
        return this.componentes;
    }

    public double getLitros() {
        return this.litros;
    }
}
