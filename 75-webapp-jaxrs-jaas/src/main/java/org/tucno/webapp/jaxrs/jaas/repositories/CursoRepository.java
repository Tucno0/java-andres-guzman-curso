package org.tucno.webapp.jaxrs.jaas.repositories;

import org.tucno.webapp.jaxrs.jaas.models.Curso;

import java.util.List;

public interface CursoRepository {
    public List<Curso> listar();
    public Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);
}
