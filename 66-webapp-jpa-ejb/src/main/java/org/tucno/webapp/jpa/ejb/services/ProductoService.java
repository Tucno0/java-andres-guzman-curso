package org.tucno.webapp.jpa.ejb.services;

import jakarta.ejb.Local;
import org.tucno.webapp.jpa.ejb.models.entities.Categoria;
import org.tucno.webapp.jpa.ejb.models.entities.Producto;

import java.util.List;
import java.util.Optional;

@Local
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
