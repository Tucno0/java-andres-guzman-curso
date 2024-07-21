package org.tucno.webapp.jaxrs.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import org.tucno.webapp.jaxrs.models.Curso;
import org.tucno.webapp.jaxrs.repositories.CursoRepository;

import java.util.List;
import java.util.Optional;

// La anotación @Stateless indica que la clase CursoServicioWsImpl es un EJB de tipo Stateless.
// Un EJB de tipo Stateless es un componente que no guarda estado entre las invocaciones de los métodos.
@Stateless
// La anotación @WebService indica que la clase ServicioWsImpl es un servicio web
// endpointInterface indica la interfaz que define los métodos del servicio web que se implementan en esta clase.
public class CursoServiceImpl implements CursoService {
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

    @Override
    public Optional<Curso> porId(Long id) {
        return Optional.ofNullable(cursoRepository.porId(id));
    }

    @Override
    public void eliminar(Long id) {
        cursoRepository.eliminar(id);
    }
}
