package org.tucno.springboot.app.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clientes")
// Se implementa Serializable para poder convertir la clase a bytes y poder enviarla a través de la red (JSON, XML, etc.)
public class Cliente implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Column(name = "create_at") // Se especifica el nombre de la columna en la base de datos
    @Temporal(TemporalType.DATE) // Se especifica el tipo de dato en la base de datos (DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Se especifica el formato de la fecha
    private Date createAt;

//    @PrePersist
//    public void prePersist() {
//        createAt = new Date();
//    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
