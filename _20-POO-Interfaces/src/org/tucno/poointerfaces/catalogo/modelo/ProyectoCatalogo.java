package org.tucno.poointerfaces.catalogo.modelo;

import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos= new Producto[4];
        productos[0] = new Iphone(1500, "Apple", "Crema", "Iphone 15");
        productos[1] = new TvLcd(900, "Samsung", 69);
        productos[2] = new Libro(15, new Date(), "Homero", "La odisea", "Bruno");
        productos[3] = new Comics(50, new Date(), "Marvel Comics", "Iron Man 2", "Marvel", "Iron Man");

        for ( IProducto producto : productos) {
            System.out.println(producto.toString() + "\n");
        }
    }
}
