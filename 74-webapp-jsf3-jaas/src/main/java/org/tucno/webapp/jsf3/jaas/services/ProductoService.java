package org.tucno.webapp.jsf3.jaas.services;

import jakarta.ejb.Local;
import org.tucno.webapp.jsf3.jaas.entities.Categoria;
import org.tucno.webapp.jsf3.jaas.entities.Producto;

import java.util.List;
import java.util.Optional;

// La anotación @Local se utiliza para definir una interfaz de negocio local.
// Lo que significa que la interfaz solo se puede acceder desde el mismo módulo.
@Local
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
    List<Producto> buscarPorNombre(String nombre);

    List<Categoria> listarCategorias();
    Optional<Categoria> categoriaPorId(Long id);
}
