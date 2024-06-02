package org.tucno.hibernateapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    // ManyToMany es una relación de muchos a muchos entre Alumno y Curso
    // Dueño de la relación, por eso se coloca mappedBy en la clase Curso y no en la clase Alumno
    // Tambien por eso en esta clase se coloca la anotación @JoinTable y cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
    @JoinTable(
        name = "alumnos_cursos",
        joinColumns = @JoinColumn(name = "alumno_id"),
        inverseJoinColumns = @JoinColumn(name = "curso_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"alumno_id", "curso_id"})
    )
    private List<Curso> cursos;

    public Alumno() {
        this.cursos = new ArrayList<>();
    }

    public Alumno(String nombre, String apellido, String email) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Alumno addCurso(Curso curso) {
        this.cursos.add(curso);
        curso.getAlumnos().add(this);
        return this;
    }

    public Alumno removeCurso(Curso curso) {
        this.cursos.remove(curso);
        curso.getAlumnos().remove(this);
        return this;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "   id: " + id + ",\n" +
                "   nombre: " + nombre + ",\n" +
                "   apellido: " + apellido + ",\n" +
                "   email: " + email + ",\n" +
                "   cursos: " + cursos + "\n" +
                "}," + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(id, alumno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
