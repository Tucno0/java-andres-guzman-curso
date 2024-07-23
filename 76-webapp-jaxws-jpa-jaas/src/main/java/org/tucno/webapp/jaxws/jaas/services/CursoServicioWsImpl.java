package org.tucno.webapp.jaxws.jaas.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.tucno.webapp.jaxws.jaas.repositories.CursoRepository;
import org.tucno.webapp.jaxws.jaas.models.Curso;

import java.util.List;

// La anotación @DeclareRoles indica los roles que se pueden asignar a los usuarios que acceden a los métodos de esta clase.
@DeclareRoles({"ADMIN", "USER"})
// La anotación @Stateless indica que la clase CursoServicioWsImpl es un EJB de tipo Stateless.
// Un EJB de tipo Stateless es un componente que no guarda estado entre las invocaciones de los métodos.
@Stateless
// La anotación @WebService indica que la clase ServicioWsImpl es un servicio web
// endpointInterface indica la interfaz que define los métodos del servicio web que se implementan en esta clase.
@WebService(endpointInterface = "org.tucno.webapp.jaxws.jaas.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {
    @Inject
    private CursoRepository cursoRepository;

    @RolesAllowed({"ADMIN", "USER"})
    @WebMethod
    @Override
    public List<Curso> listar() {
        return cursoRepository.listar();
    }

    @RolesAllowed({"ADMIN"})
    @WebMethod
    @Override
    public Curso guardar(Curso curso) {
        return cursoRepository.guardar(curso);
    }
}
