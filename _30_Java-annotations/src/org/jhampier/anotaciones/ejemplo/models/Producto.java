package org.jhampier.anotaciones.ejemplo.models;

import org.jhampier.anotaciones.ejemplo.annotations.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {
    @JsonAtributo() // se anota el atributo nombre para que se serialice en JSON
    private  String nombre;
    @JsonAtributo // si no se especifica el nombre del atributo se usa el nombre del atributo
    private  Long precio;
    private LocalDate fecha;

    public Producto(String nombre, Long precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    private void init() {
        this.nombre = Arrays.stream(this.nombre.split(""))
                .map( palabra -> palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
}
