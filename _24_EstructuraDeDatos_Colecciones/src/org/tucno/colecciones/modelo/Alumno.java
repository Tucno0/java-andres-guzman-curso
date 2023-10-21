package org.tucno.colecciones.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno>{
    private String nombre;
    private Integer nota;

    public Alumno() {
    }

    public Alumno(String nombre, Integer nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombre + " - " + nota;
    }

    // Implementación de Comparable
    @Override
    public int compareTo(Alumno a) {
        // Si la nota es null
        if (this.nombre == null) {
            return 0;
        }
        // Ordena por nombre
        return this.nombre.compareTo(a.nombre);

        // Ordena por nota con int
        // Si la nota es igual a la nota del alumno a comparar
//        if (this.nota == a.nota) return 0;
//        // Si la nota es menor a la nota del alumno a comparar
//        if (this.nota < a.nota) {
//            return -1;
//        // Si la nota es mayor a la nota del alumno a comparar
//        } else {
//            return 1;
//        }

        // Ordena por nota con Integer
//        if (this.nota == null) {
//            return 0;
//        }
//        return this.nota.compareTo(a.nota);
    }

// Implementación de equals() y hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(nota, alumno.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nota);
    }
}
