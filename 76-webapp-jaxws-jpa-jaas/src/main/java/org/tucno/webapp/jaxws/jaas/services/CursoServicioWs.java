package org.tucno.webapp.jaxws.jaas.services;

import jakarta.jws.WebService;
import org.tucno.webapp.jaxws.jaas.models.Curso;

import java.util.List;

// La anotación @WebService indica que la interfaz ServicioWs es un servicio web
// que puede ser accedido por un cliente a través de una URL específica (endpoint).
@WebService
public interface CursoServicioWs {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
