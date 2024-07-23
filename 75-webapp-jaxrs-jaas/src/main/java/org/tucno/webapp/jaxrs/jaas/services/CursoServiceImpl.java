package org.tucno.webapp.jaxrs.jaas.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.tucno.webapp.jaxrs.jaas.repositories.CursoRepository;
import org.tucno.webapp.jaxrs.jaas.models.Curso;

import java.util.List;
import java.util.Optional;

// La anotación @Stateless indica que la clase CursoServicioWsImpl es un EJB de tipo Stateless.
// Un EJB de tipo Stateless es un componente que no guarda estado entre las invocaciones de los métodos.
@Stateless
// La anotación @WebService indica que la clase ServicioWsImpl es un servicio web
// endpointInterface indica la interfaz que define los métodos del servicio web que se implementan en esta clase.
@DeclareRoles({"USER", "ADMIN"})
//@PermitAll
public class CursoServiceImpl implements CursoService {
    @Inject
    private CursoRepository cursoRepository;

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public List<Curso> listar() {
        return cursoRepository.listar();
    }

    @Override
    @RolesAllowed("ADMIN")
    public Curso guardar(Curso curso) {
        return cursoRepository.guardar(curso);
    }

    @Override
    @RolesAllowed({"USER", "ADMIN"})
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(cursoRepository.porId(id));
    }

    @Override
    @RolesAllowed("ADMIN")
    public void eliminar(Long id) {
        cursoRepository.eliminar(id);
    }
}
