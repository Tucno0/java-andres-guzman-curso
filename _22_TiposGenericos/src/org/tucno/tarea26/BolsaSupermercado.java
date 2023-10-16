package org.tucno.tarea26;

import java.util.ArrayList;
import java.util.List;

public class BolsaSupermercado <P> {
    private List<P> productos;
    private int capacidad;

    public BolsaSupermercado(int capacidad) {
        this.capacidad = capacidad;
        this.productos = new ArrayList<>();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public BolsaSupermercado<P> addProducto(P producto) {
        if (productos.size() < capacidad) {
            productos.add(producto);
        } else {
            throw new RuntimeException("No hay mas espacio en la bolsa");
        }
        return this;
    }

    public List<P> getProductos() {
        return this.productos;
    }
}
