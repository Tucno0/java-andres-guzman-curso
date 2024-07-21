package org.tucno.webapp.jaxws.services;

import jakarta.jws.WebService;
import org.tucno.webapp.jaxws.models.Curso;

import java.util.List;

// La anotación @WebService indica que la interfaz ServicioWs es un servicio web
// que puede ser accedido por un cliente a través de una URL específica (endpoint).
@WebService
public interface ServicioWs {
    String saludar (String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}
