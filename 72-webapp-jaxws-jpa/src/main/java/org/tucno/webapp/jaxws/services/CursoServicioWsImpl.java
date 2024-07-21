package org.tucno.webapp.jaxws.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.tucno.webapp.jaxws.models.Curso;
import org.tucno.webapp.jaxws.repositories.CursoRepository;

import java.util.List;

// La anotación @Stateless indica que la clase CursoServicioWsImpl es un EJB de tipo Stateless.
// Un EJB de tipo Stateless es un componente que no guarda estado entre las invocaciones de los métodos.
@Stateless
// La anotación @WebService indica que la clase ServicioWsImpl es un servicio web
// endpointInterface indica la interfaz que define los métodos del servicio web que se implementan en esta clase.
@WebService(endpointInterface = "org.tucno.webapp.jaxws.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {
    @Inject
    private CursoRepository cursoRepository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return cursoRepository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return cursoRepository.guardar(curso);
    }
}
