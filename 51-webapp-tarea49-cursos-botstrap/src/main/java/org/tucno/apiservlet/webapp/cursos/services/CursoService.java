package org.tucno.apiservlet.webapp.cursos.services;

import org.tucno.apiservlet.webapp.cursos.models.Curso;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar() throws SQLException;
    List<Curso> porNombre(String nombre) throws SQLException;
    Optional<Curso> porId(Long id);
    void guardar(Curso curso);
    void eliminar(Long id);
}
