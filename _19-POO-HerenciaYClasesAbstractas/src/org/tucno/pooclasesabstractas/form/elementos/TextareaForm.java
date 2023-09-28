package org.tucno.pooclasesabstractas.form.elementos;

public class TextareaForm extends ElementoForm {
    // ATRIBUTOS
    private int filas;
    private int columnas;

    // CONSTRUCTORES

    public TextareaForm(String nombre) {
        super(nombre);
    }

    public TextareaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.filas = filas;
        this.columnas = columnas;
    }
    // GETTERS Y SETTERS

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    // MÉTODOS
    @Override
    public String dibujarHtml() {
        return "<textarea name=\"" + this.nombre + "\" rows=\"" + this.filas + "\" cols=\"" + this.columnas + "\">" + this.valor + "</textarea>";
    }
}
