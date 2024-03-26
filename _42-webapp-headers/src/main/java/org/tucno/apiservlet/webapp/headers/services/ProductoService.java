package org.tucno.apiservlet.webapp.headers.services;

import org.tucno.apiservlet.webapp.headers.models.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
}
