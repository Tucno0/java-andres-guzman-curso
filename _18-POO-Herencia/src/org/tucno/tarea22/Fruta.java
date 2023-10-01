package org.tucno.tarea22;

public class Fruta extends Producto{
    private double peso;
    private String color;

    public Fruta() {
    }

    public Fruta(String nombre, double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double pero) {
        this.peso = pero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\nPeso: " + peso + "kg" +
                "\nColor: " + color;
    }
}
