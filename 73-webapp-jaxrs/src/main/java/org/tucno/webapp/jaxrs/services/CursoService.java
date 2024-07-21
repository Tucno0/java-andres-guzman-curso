package org.tucno.webapp.jaxrs.services;

import jakarta.ejb.Local;
import jakarta.jws.WebService;
import org.tucno.webapp.jaxrs.models.Curso;

import java.util.List;
import java.util.Optional;

// La anotación @Local indica que la interfaz CursoService es un EJB de tipo Local.
// Un EJB de tipo Local es un componente que se ejecuta en el mismo contenedor de EJBs que el cliente.
@Local
// La anotación @WebService indica que la interfaz ServicioWs es un servicio web
// que puede ser accedido por un cliente a través de una URL específica (endpoint).
@WebService
public interface CursoService {
    List<Curso> listar();
    Curso guardar(Curso curso);
    Optional<Curso> porId(Long id);
    void eliminar(Long id);
}
