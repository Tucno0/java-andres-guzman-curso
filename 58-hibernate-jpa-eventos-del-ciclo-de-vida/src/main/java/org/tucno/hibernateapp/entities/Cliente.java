package org.tucno.hibernateapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

// Entity es una anotación de JPA que indica que la clase es una entidad de la base de datos
@Entity
@Table(name = "clientes") // Indica el nombre de la tabla en la base de datos
public class Cliente {
    @Id // Indica que el campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue indica que el campo es autoincremental
    private Long id;

    // Column indica que el campo es una columna de la tabla, se puede omitir si el nombre del campo es igual al de la columna
    private String nombre;
    private String apellido;

    @Column(name = "forma_pago") // Indica el nombre de la columna en la base de datos
    private String formaPago;

    // Embedded es una anotación de JPA que indica que la clase es embebible, es decir, que se puede usar como parte de otra entidad
    // En este caso, la clase Auditoria se usará como parte de la entidad Cliente para registrar la fecha de creación y edición
    @Embedded
    private Auditoria auditoria = new Auditoria();

    // Constructor vacío: necesario para que JPA pueda instanciar la clase
    public Cliente() {
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(Long id, String nombre, String apellido, String formaPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public String toString() {
        LocalDateTime creadoEn = this.auditoria != null ? this.auditoria.getCreadoEn() : null;
        LocalDateTime editadoEn = this.auditoria != null ? this.auditoria.getEditadoEn() : null;

        return "{" + "\n" +
                    "   id: " + id + ",\n" +
                    "   nombre: " + nombre + ",\n" +
                    "   apellido: " + apellido + ",\n" +
                    "   formaPago: " + formaPago + ",\n" +
                    "   creadoEn: " + creadoEn + ",\n" +
                    "   editadoEn: " + editadoEn + "\n" +
                "},";
    }
}
