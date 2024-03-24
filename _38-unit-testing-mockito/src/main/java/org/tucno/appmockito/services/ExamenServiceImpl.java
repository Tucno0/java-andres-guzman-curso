package org.tucno.appmockito.services;

import org.tucno.appmockito.models.Examen;
import org.tucno.appmockito.repositories.ExamenRepository;
import org.tucno.appmockito.repositories.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImpl implements ExamenService {
    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {
        Optional<Examen> examenOptional = examenRepository.findAll().stream()
                .filter(e -> e.getNombre().equals(nombre))
                .findFirst();

        return examenOptional;
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;

        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }

        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()) {
            preguntaRepository.guardarVarias(examen.getPreguntas());
        }

        return examenRepository.guardar(examen);
    }
}
