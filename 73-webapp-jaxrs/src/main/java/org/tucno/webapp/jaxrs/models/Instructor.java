package org.tucno.webapp.jaxrs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructores")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;

    // mappedBy: Indica el nombre del campo en la clase Curso que mapea esta relación.
    // cascade: Indica que las operaciones de guardado, actualización y eliminación realizadas en la entidad Instructor se propagarán a la entidad Curso.
    // Por defecto el fetch es LAZY, lo que significa que los cursos no se cargarán automáticamente al recuperar un instructor.
    // Se cambia a EAGER para que los cursos se carguen automáticamente al recuperar un instructor, asi se evita el problema de la excepción LazyInitializationException.

    // Se agrega la anotación @JsonIgnoreProperties para ignorar la propiedad instructor de la clase Curso al serializar un objeto Curso a JSON.
    // Esto evita problemas de recursión al mostrar un curso con su instructor.
    // hidernateLazyInitializer y handler son propiedades que se agregan al serializar un objeto Curso a JSON.
    // para evitar problemas de recursión, cuando queda en el cache de hibernate.
    @JsonIgnoreProperties({"instructor", "hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    // Se agrega el constructor vacío para que JPA pueda instanciar la clase Instructor.
    public Instructor() {
        this.cursos = new ArrayList<>();
    }

    public Instructor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
