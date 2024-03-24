package org.tucno.appmockito.repositories;

import org.tucno.appmockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class ExamenRepositoryImpl implements ExamenRepository {
    @Override
    public Examen guardar(Examen examen) {
        return null;
    }

    @Override
    public List<Examen> findAll() {
        return Arrays.asList(
            new Examen(1L, "Matemáticas"),
            new Examen(2L, "Lenguaje"),
            new Examen(3L, "Historia")
        );
    }
}
