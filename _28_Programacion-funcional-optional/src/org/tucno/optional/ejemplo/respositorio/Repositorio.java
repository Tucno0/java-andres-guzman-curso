package org.tucno.optional.ejemplo.respositorio;

import org.tucno.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar(String nombre);
}
