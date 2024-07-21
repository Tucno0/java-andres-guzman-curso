package org.tucno.webapp.jaxrs.repositories;

import org.tucno.webapp.jaxrs.models.Curso;

import java.util.List;

public interface CursoRepository {
    public List<Curso> listar();
    public Curso guardar(Curso curso);
    Curso porId(Long id);
    void eliminar(Long id);
}
