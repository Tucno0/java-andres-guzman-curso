package org.tucno.webpp.ejb.services;

import jakarta.ejb.Local;
import org.tucno.webpp.ejb.models.Producto;

import java.util.List;

// @Local: Indica que la interfaz es local, es decir, que se puede acceder a ella desde el mismo servidor de aplicaciones
@Local
public interface ServiceEjbLocal {
    String saludar(String nombre);
    List<Producto> listar();
    Producto crear(Producto producto);
}
