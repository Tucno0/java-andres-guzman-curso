package org.tucno.appmockito.services;

import org.tucno.appmockito.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Examen> EXAMENES = Arrays.asList(
        new Examen(1L, "Matemáticas"),
        new Examen(2L, "Lenguaje"),
        new Examen(3L, "Historia")
    );

    public final static List<String> PREGUNTAS = Arrays.asList(
        "aritmética",
        "integrales",
        "derivadas",
        "trigonometría",
        "geometría"
    );

    public final static Examen EXAMEN = new Examen(null, "Física");
}
