package org.tucno.apiservlet.webapp.jdbc.services;

import org.tucno.apiservlet.webapp.jdbc.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
}
