package org.tucno.springboot.interceptores.app.models.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Pais {
//    @NotNull
    private Integer id;

//    @NotEmpty
    // Ya no es necesario validar los campos de la clase Pais porque ya se valida todo el objeto completo en la clase Usuario
    private String codigo;
    private String nombre;

    public Pais() {
    }

    public Pais(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Es necesario sobreescribir el método toString para que el PropertyEditor funcione correctamente en el formulario
    // Esto para poner el id del objeto en el campo del formulario por defecto
    @Override
    public String toString() {
        return this.id.toString();
    }
}
