package org.tucno.webapp.jsf3.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.tucno.webapp.jsf3.entities.Producto;
import org.tucno.webapp.jsf3.repositories.CrudRepository;

import java.util.List;
import java.util.Optional;

// La anotación @Stateless se utiliza para definir un EJB sin estado.
// Lo que significa que el contenedor no necesita mantener el estado del EJB entre las invocaciones de los métodos.
// Un EJB sin estado no guarda información de estado entre las invocaciones de los métodos.
@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    private CrudRepository<Producto> productoRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(productoRepository.porId(id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
