package org.tucno.appmockito.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.tucno.appmockito.models.Examen;
import org.tucno.appmockito.repositories.ExamenRepository;
import org.tucno.appmockito.repositories.PreguntaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class _01_ExamenServiceImplTest {
    ExamenRepository examenRepository;
    ExamenService examenService;
    PreguntaRepository preguntaRepository;

    @BeforeEach
    void setUp() {
        // Creamos un mock del repositorio de examen con Mockito.mock
        examenRepository = Mockito.mock(ExamenRepository.class);
        preguntaRepository = Mockito.mock(PreguntaRepository.class);
        examenService = new ExamenServiceImpl(examenRepository, preguntaRepository);

    }

    @Test
    void findExamenPorNombre() {
        // Cuando se llame al método findAll del repositorio de examen, retornará la lista de examenes
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = examenService.findExamenPorNombre("Matemáticas");

        assertTrue(examen.isPresent()); // Verifica que el examen no sea nulo
        assertEquals("Matemáticas", examen.orElseThrow().getNombre()); // Verifica que el nombre del examen sea "Matemáticas"
        assertEquals(1L, examen.orElseThrow().getId()); // Verifica que el id del examen sea 1
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> examenes = Collections.emptyList();

        // Cuando se llame al método findAll del repositorio de examen, retornará la lista de exámenes
        // when() es un método estático de Mockito que permite configurar el comportamiento de un mock de un objeto
        // En este caso estamos configurando el comportamiento del mock examenRepository para que retorne la lista de
        // examenes cuando se llame al método findAll del repositorio de examen
        Mockito.when(examenRepository.findAll()).thenReturn(examenes);
        Optional<Examen> examen = examenService.findExamenPorNombre("Matemáticas");

        assertFalse(examen.isPresent()); // Verifica que el examen no sea nulo
    }

    @Test
    void testPreguntasExamen() {
        // Cuando se llame al método findAll del repositorio de examen, retornará la lista de examenes
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        // Cuando se llame al método findPreguntasPorExamenId del repositorio de pregunta, retornará la lista de preguntas
        Mockito.when(preguntaRepository.findPreguntasPorExamenId(1L)).thenReturn(Datos.PREGUNTAS);

        Examen examen = examenService.findExamenPorNombreConPreguntas("Matemáticas");

        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmética"));
    }

    @Test
    void testPreguntasExamenVerify() {
        // Cuando se llame al método findAll del repositorio de examen, retornará la lista de examenes
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        // Cuando se llame al método findPreguntasPorExamenId del repositorio de pregunta, retornará la lista de preguntas
        Mockito.when(preguntaRepository.findPreguntasPorExamenId(1L)).thenReturn(Datos.PREGUNTAS);

        Examen examen = examenService.findExamenPorNombreConPreguntas("Matemáticas");

        assertEquals(5, examen.getPreguntas().size());
        assertTrue(examen.getPreguntas().contains("aritmética"));

        // Verifica que el método findAll del repositorio de examen se haya llamado al menos una vez con el método verify
        Mockito.verify(examenRepository).findAll();
        // Verifica que el método findPreguntasPorExamenId del repositorio de pregunta se haya llamado al menos una vez con el método verify
        Mockito.verify(preguntaRepository).findPreguntasPorExamenId(1L);
    }

    @Test
    void testNoExisteExamenVerify() {
        // Cuando se llame al método findAll del repositorio de examen, retornará la lista de examenes
        Mockito.when(examenRepository.findAll()).thenReturn(Datos.EXAMENES);

        // Cuando se llame al método findPreguntasPorExamenId del repositorio de pregunta, retornará la lista de preguntas
        Mockito.when(preguntaRepository.findPreguntasPorExamenId(1L)).thenReturn(Datos.PREGUNTAS);

        Examen examen = examenService.findExamenPorNombreConPreguntas("Matemáticas");

        assertNotNull(examen);

        // Verifica que el método findAll del repositorio de examen se haya llamado al menos una vez con el método verify
        Mockito.verify(examenRepository).findAll();
        // Verifica que el método findPreguntasPorExamenId del repositorio de pregunta se haya llamado al menos una vez con el método verify
        Mockito.verify(preguntaRepository).findPreguntasPorExamenId(1L);
    }
}