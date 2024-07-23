package org.tucno.webapp.jaxws.jaas.repositories;

import org.tucno.webapp.jaxws.jaas.models.Curso;

import java.util.List;

public interface CursoRepository {
    public List<Curso> listar();
    public Curso guardar(Curso curso);
}
