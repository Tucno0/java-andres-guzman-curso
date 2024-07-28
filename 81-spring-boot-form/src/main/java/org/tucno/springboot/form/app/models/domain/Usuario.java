package org.tucno.springboot.form.app.models.domain;

import jakarta.validation.constraints.*;
import org.tucno.springboot.form.app.validators.IdentificadorRegex;
import org.tucno.springboot.form.app.validators.Requerido;

import java.util.Date;
import java.util.List;

public class Usuario {
    private String id;

    //@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}") // Valida que el campo cumpla con una expresión regular
    @IdentificadorRegex // Validador personalizado con una expresión regular
    private String codigo;

    //@NotEmpty(message = "El nombre no puede estar vacío") // Se puede personalizar el mensaje de error
    private String nombre;

    @Requerido // Valida que el campo no esté vacío
    private String apellido;

    @NotBlank // Valida que el campo no esté vacío, es lo mismo que @NotEmpty pero no permite espacios en blanco
    @Size(min = 3, max = 8) // Valida que el campo tenga una longitud mínima y máxima
    private String username;

    @NotEmpty
    private String password;

    @Requerido
    @Email(message = "Correo con formato incorrecto") // Valida que el campo tenga un formato de correo electrónico
    private String email;

    @NotNull // Valida que el campo no sea nulo
    @Min(5) // Valida que el campo sea mayor o igual al valor indicado
    @Max(5000) // Valida que el campo sea menor o igual al valor indicado
    private Integer edad;

    @NotNull
    @Past // Valida que la fecha sea anterior a la fecha actual
//    @Future // Valida que la fecha sea posterior a la fecha actual
//    @DateTimeFormat(pattern = "yyyy-MM-dd") // Formato de la fecha
    private Date fechaNacimiento;

//    @Valid // Valida las propiedades del objeto anidado (Pais)
    @NotNull
    private Pais pais;

//    @NotEmpty
//    private List<String> roles;

    @NotEmpty
    private List<Role> roles;

    @NotEmpty
    private String genero;

    @NotNull
    private Boolean habilitado;

    // Se puede utilizar @JsonIgnore para que no se muestre en la respuesta
    private String valorSecreto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getValorSecreto() {
        return valorSecreto;
    }

    public void setValorSecreto(String valorSecreto) {
        this.valorSecreto = valorSecreto;
    }
}
