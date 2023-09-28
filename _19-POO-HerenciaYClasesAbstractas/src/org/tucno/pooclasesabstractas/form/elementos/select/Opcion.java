package org.tucno.pooclasesabstractas.form.elementos.select;

public class Opcion {
    // ATRIBUTOS
    private String valor;
    private String nombre;
    private boolean selected;

    // CONSTRUCTORES
    public Opcion() {
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    // GETTERS Y SETTERS

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Opcion setSelected() {
        this.selected = true;
        return this;
    }

    // MÉTODOS

    public boolean isSelected() {
        return selected;
    }
}
