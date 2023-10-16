package org.tucno.poointerfaces.catalogo.modelo;

public class TvLcd extends Electronico {
    private int pulgada;

    public TvLcd(int precio, String fabricante, int pulgada) {
        super(precio, fabricante);
        this.pulgada = pulgada;
    }

    public int getPulgada() {
        return pulgada;
    }

    @Override
    public double getPrecioVenta() {
        return 0;
    }

    @Override
    public String toString() {
        return "TvLcd{" +
                "pulgada=" + pulgada +
                ", fabricante='" + fabricante + '\'' +
                ", precio=" + precio +
                '}';
    }
}
