package org.tucno.webapp.jsf3.services;

import jakarta.ejb.Local;
import org.tucno.webapp.jsf3.entities.Producto;

import java.util.List;
import java.util.Optional;

// La anotación @Local se utiliza para definir una interfaz de negocio local.
// Lo que significa que la interfaz solo se puede acceder desde el mismo módulo.
@Local
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
}
