package org.tucno.apiservlet.webapp.cursos.services;

import org.tucno.apiservlet.webapp.cursos.models.Curso;

import java.sql.SQLException;
import java.util.List;

public interface CursoService {
    List<Curso> listar() throws SQLException;
    List<Curso> porNombre(String nombre) throws SQLException;
}
