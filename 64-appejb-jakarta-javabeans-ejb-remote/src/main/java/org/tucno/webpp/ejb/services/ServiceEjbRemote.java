package org.tucno.webpp.ejb.services;

import jakarta.ejb.Remote;
import org.tucno.webpp.ejb.models.Producto;

import java.util.List;

// @Remote: Indica que la interfaz es remota, es decir, que se puede acceder a ella desde un cliente
@Remote
public interface ServiceEjbRemote {
    String saludar(String nombre);
    List<Producto> listar();
    Producto crear(Producto producto);
}
