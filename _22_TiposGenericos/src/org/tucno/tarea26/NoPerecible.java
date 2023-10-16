package org.tucno.tarea26;

public class NoPerecible extends Producto{
    private int contenido;
    private int calorias;

    public NoPerecible(String nombre, double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return this.contenido;
    }

    public int getCalorias() {
        return this.calorias;
    }
}
