package org.tucno.hibernateapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

// Embeddable es una anotación de JPA que indica que la clase es embebible, es decir, que se puede usar como parte de otra entidad
// En este caso, la clase Auditoria se usará como parte de otras entidades para registrar la fecha de creación y edición
@Embeddable
public class Auditoria {
    @Column(name = "creado_en")
    private LocalDateTime creadoEn;

    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    // PrePersist es una anotación de JPA que indica que el método se ejecutará antes de persistir la entidad en la base de datos
    // Por ejemplo, se puede usar para validar los datos antes de guardarlos en la base de datos
    @PrePersist
    public void prePersist() {
        System.out.println("Antes de persistir");
        this.creadoEn = LocalDateTime.now();
    }

    // PostPersist es una anotación de JPA que indica que el método se ejecutará después de persistir la entidad en la base de datos
    // Por ejemplo, se puede usar para enviar una notificación después de guardar los datos en la base de datos
    @PreUpdate
    public void preUpdate() {
        System.out.println("Antes de actualizar");
        this.editadoEn = LocalDateTime.now();
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }

}
