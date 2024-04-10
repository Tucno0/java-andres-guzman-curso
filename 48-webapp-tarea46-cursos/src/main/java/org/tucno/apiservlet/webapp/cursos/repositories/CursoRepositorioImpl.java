package org.tucno.apiservlet.webapp.cursos.repositories;

import org.tucno.apiservlet.webapp.cursos.models.Curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Repository<Curso>{
    private Connection connection;

    public CursoRepositorioImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Curso> listar() throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try (
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cursos")
        ) {
            while ( resultSet.next() ) {
                Curso curso = getCurso(resultSet);
                cursos.add(curso);
            }
        }

        return cursos;
    }

    @Override
    public List<Curso> porNombre(String nombre) throws SQLException {
        List<Curso> cursos = new ArrayList<>();

        try (
            Statement statement = connection.createStatement();
        ) {
            String query = STR."""
                SELECT * FROM cursos
                WHERE nombre LIKE '%\{nombre}%'
            """;

            try (ResultSet resultSet = statement.executeQuery(query) ) {
                while ( resultSet.next() ) {
                    Curso curso = getCurso(resultSet);
                    cursos.add(curso);
                }
            }
        }

        return cursos;
    }

    private Curso getCurso(ResultSet resultSet) throws SQLException {
        Curso curso = new Curso();

        curso.setId(resultSet.getLong("id"));
        curso.setNombre(resultSet.getString("nombre"));
        curso.setDescripcion(resultSet.getString("descripcion"));
        curso.setInstructor(resultSet.getString("instructor"));
        curso.setDuracion(resultSet.getDouble("duracion"));

        return curso;
    }
}
