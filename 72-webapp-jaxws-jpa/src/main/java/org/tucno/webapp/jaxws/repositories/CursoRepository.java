package org.tucno.webapp.jaxws.repositories;

import org.tucno.webapp.jaxws.models.Curso;

import java.util.List;

public interface CursoRepository {
    public List<Curso> listar();
    public Curso guardar(Curso curso);
}
