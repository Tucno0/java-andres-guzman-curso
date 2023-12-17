package org.tucno.apistream.tareas;

import org.tucno.apistream.tareas.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class Tarea34 {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(10, 2));
        productos.add(new Producto(20, 3));
        productos.add(new Producto(30, 4));
        productos.add(new Producto(40, 5));
        productos.add(new Producto(50, 6));

        double total = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();

        System.out.println("total = " + total);
    }
}
