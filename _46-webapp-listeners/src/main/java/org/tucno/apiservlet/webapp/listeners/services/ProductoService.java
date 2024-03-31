package org.tucno.apiservlet.webapp.listeners.services;

import org.tucno.apiservlet.webapp.listeners.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
}
