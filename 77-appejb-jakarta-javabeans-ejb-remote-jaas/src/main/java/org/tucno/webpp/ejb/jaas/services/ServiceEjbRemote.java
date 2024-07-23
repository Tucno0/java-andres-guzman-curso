package org.tucno.webpp.ejb.jaas.services;

import jakarta.ejb.Remote;
import org.tucno.webpp.ejb.jaas.models.Producto;

import java.util.List;

// @Remote: Indica que la interfaz es remota, es decir, que se puede acceder a ella desde un cliente
@Remote
public interface ServiceEjbRemote {
    String saludar(String nombre);
    List<Producto> listar();
    Producto crear(Producto producto);
}
