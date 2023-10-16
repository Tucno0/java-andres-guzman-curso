package org.tucno.tarea26;

public class Fruta extends Producto{
    private double peso;
    private String color;

    public Fruta(String nombre, double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return this.peso;
    }

    public String getColor() {
        return this.color;
    }
}
