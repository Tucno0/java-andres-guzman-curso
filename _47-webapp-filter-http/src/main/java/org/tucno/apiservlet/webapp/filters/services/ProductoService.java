package org.tucno.apiservlet.webapp.filters.services;

import org.tucno.apiservlet.webapp.filters.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
}
