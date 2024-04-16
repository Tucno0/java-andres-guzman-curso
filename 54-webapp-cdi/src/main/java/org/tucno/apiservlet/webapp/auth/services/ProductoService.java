package org.tucno.apiservlet.webapp.auth.services;

import org.tucno.apiservlet.webapp.auth.models.Categoria;
import org.tucno.apiservlet.webapp.auth.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> obtenerPorId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);

    List<Categoria> listarCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    void guardarCategoria(Categoria categoria);
    void eliminarCategoria(Long id);
}
