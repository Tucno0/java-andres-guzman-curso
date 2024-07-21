package org.tucno.webapp.jaxrs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

// La anotación @XmlRootElement indica que la clase Curso es un elemento raíz de un documento XML.
// Es decir, que la clase Curso puede ser convertida a un documento XML.
// Esta anotación es necesaria para que la clase Curso pueda ser devuelta en una respuesta HTTP en formato XML.
// Solo es necesaria si se quiere devolver la clase Curso en formato XML.
//@XmlRootElement
@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    // @XmlTransient: Es una anotación que se utiliza para que el campo no se muestre en el XML generado.
    // Sirve para ocultar campos que no se quieren mostrar en el XML y también para evitar problemas de recursión.
//    @XmlTransient
    // La anotación @JsonbTransient se utiliza para que el campo no se muestre en el JSON generado.
//    @JsonbTransient
    // La anotación @JsonIgnore se utiliza para que el campo no se muestre en el JSON generado.
//    @JsonIgnore
    // La anotación @JsonIgnoreProperties se utiliza para ignorar propiedades de la clase Instructor.
    // En este caso, se ignora la propiedad cursos de la clase Instructor.
    // La propiedad cursos de la clase Instructor no se mostrará en el JSON generado.
    // Esto evita problemas de recursión al mostrar un instructor con sus cursos.
    @JsonIgnoreProperties({"cursos"})
    @ManyToOne(fetch = FetchType.LAZY) // Dueño de la relación
    private Instructor instructor;
    private Double duracion;

    public Curso() {
    }

    public Curso(String nombre) {
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
