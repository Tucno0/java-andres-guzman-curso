package org.tucno.appmockito.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.tucno.appmockito.models.Examen;
import org.tucno.appmockito.repositories.ExamenRepository;
import org.tucno.appmockito.repositories.PreguntaRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// Con la anotación @ExtendWith(MockitoExtension.class), Mockito inicializa los mocks y el servicio antes de cada prueba
// Por lo tanto, no es necesario inicializar los mocks y el servicio en el método setUp
@ExtendWith(MockitoExtension.class)
class _02_Mock_InjectMock_ExtendWith {
    @Mock // Con la anotación @Mock, Mockito crea un mock del repositorio de examen y lo inyecta en el servicio de examen
    ExamenRepository examenRepository;
    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks // Con la anotación @InjectMocks, Mockito inyecta los mocks de los repositorios en el servicio de examen y crea una instancia del servicio
    ExamenServiceImpl examenService;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this); // Inicializa los mocks y el servicio antes de cada prueba
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

    @Test
    void testGuardarExamen() {
        // Given (Dado) - Arrange
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);

        // Cuando se llame al método guardar del repositorio de examen, retornará el examen guardado
        // any(Examen.class) es un método de Mockito que permite pasar cualquier instancia de la clase Examen como argumento
        Mockito.when(examenRepository.guardar(Mockito.any(Examen.class))).then(new Answer<Examen>() {
            Long secuencia = 8L;
            @Override
            public Examen answer(InvocationOnMock invocationOnMock) throws Throwable {
                Examen examen = invocationOnMock.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });

        // When (Cuando) - Act
        Examen examenGuardado = examenService.guardar(newExamen);

        // Then (Entonces) - Assert
        assertNotNull(examenGuardado.getId());
        assertEquals(8L, examenGuardado.getId());
        assertEquals("Física", examenGuardado.getNombre());

        // Verifica que el método guardar del repositorio de examen se haya llamado al menos una vez con el método verify
        Mockito.verify(examenRepository).guardar(Mockito.any(Examen.class));
        // Verifica que el método guardarVarias del repositorio de pregunta se haya llamado al menos una vez con el método verify
        Mockito.verify(preguntaRepository).guardarVarias(Mockito.anyList());
    }
}