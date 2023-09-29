package org.tucno.poointerfaces.imprenta.modelo;

public enum Genero {
    DRAMA("Drama"),
    ACCION("Acción"),
    AVENTURA("Aventura"),
    TERROR("Terror"),
    CIENCIA_FICCION("Ciencia Ficción"),
    PROGRAMACION("Programación");

    private String descripcion;

    private Genero(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
