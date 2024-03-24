package org.tucno.appmockito.repositories;

import org.tucno.appmockito.models.Examen;

import java.util.List;

public interface ExamenRepository {
    Examen guardar(Examen examen);
    List<Examen> findAll();
}
