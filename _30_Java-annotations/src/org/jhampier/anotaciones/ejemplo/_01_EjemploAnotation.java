package org.jhampier.anotaciones.ejemplo;

import org.jhampier.anotaciones.ejemplo.models.Producto;
import org.jhampier.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class _01_EjemploAnotation {
    public static void main(String[] args) {
        Producto producto = new Producto("laptop", 1000L);
        producto.setFecha(LocalDate.now());

        System.out.println("JSON: " + JsonSerializador.convertirAJson(producto));
    }
}
