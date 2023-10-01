package org.tucno.tarea22;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Producto leche = new Lacteo("Leche", 1.5, 1, 3);
        productos.add(leche);
        Producto queso = new Lacteo("Queso", 2.5, 2, 5);
        productos.add(queso);
        Producto naranja = new Fruta("Naranja", 1.5, 1, "Naranja");
        productos.add(naranja);
        Producto manzana = new Fruta("Manzana", 2.5, 2, "Rojo");
        productos.add(manzana);
        Producto jabon = new Limpieza("Jabón", 1.5, "Sosa", 1);
        productos.add(jabon);
        Producto detergente = new Limpieza("Detergente", 2.5, "Sosa", 2);
        productos.add(detergente);
        Producto arroz = new NoPerecible("Arroz", 1.5, 1, 3);
        productos.add(arroz);
        Producto pasta = new NoPerecible("Pasta", 2.5, 2, 5);
        productos.add(pasta);

        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
