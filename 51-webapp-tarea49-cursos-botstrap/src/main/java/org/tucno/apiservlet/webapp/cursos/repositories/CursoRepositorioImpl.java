package org.tucno.apiservlet.webapp.cursos.repositories;

import org.tucno.apiservlet.webapp.cursos.models.Curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Repository<Curso>{
    private final Connection connection;

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

    @Override
    public Curso porId(Long id) throws SQLException {
        Curso curso = null;

        try (
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(STR."SELECT * FROM cursos WHERE id = \{id}")
        ) {

            if (resultSet.next()) {
                curso = getCurso(resultSet);
            }
        }

        return curso;
    }

    @Override
    public void guardar(Curso curso) throws SQLException {
        String query;

        if (curso.getId() != null && curso.getId() > 0) {
            query = STR."""
                UPDATE cursos
                SET nombre = '\{curso.getNombre()}',
                    descripcion = '\{curso.getDescripcion()}',
                    instructor = '\{curso.getInstructor()}',
                    duracion = \{curso.getDuracion()}
                WHERE id = \{curso.getId()}
            """;
        } else {
            query = STR."""
                INSERT INTO cursos (nombre, descripcion, instructor, duracion)
                VALUES ('\{curso.getNombre()}', '\{curso.getDescripcion()}', '\{curso.getInstructor()}', \{curso.getDuracion()})
            """;
        }

        try (
            Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(query);
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = STR."DELETE FROM cursos WHERE id = \{id}";

        try ( Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        }
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
