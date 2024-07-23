package org.tucno.webapp.jsf3.jaas.repositories;

import org.tucno.webapp.jsf3.jaas.entities.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto> {
    List<Producto> buscarPorNombre(String nombre);
}
