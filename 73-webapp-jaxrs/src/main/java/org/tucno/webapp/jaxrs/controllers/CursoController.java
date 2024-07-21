package org.tucno.webapp.jaxrs.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.tucno.webapp.jaxrs.models.Curso;
import org.tucno.webapp.jaxrs.services.CursoService;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
// La anotación @Produces indica que los métodos de esta clase producen respuestas en formato XML.
// Si no se especifica un tipo de respuesta, el formato por defecto es JSON.
//@Produces(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class CursoController {
    @Inject
    private CursoService cursoService;

    // Opcional
//    @GET
//    public Response listar() {
//        return Response.ok(cursoService.listar()).build();
//    }

    // Se puede cambiar el tipo de respuesta de la lista de cursos a List<Curso> y quitar el Response.
    // No es necesario devolver un Response, ya que JAX-RS se encarga de convertir la lista de cursos a XML.
    @GET
    public List<Curso> listar() {
        return cursoService.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Optional<Curso> curso = cursoService.porId(id);

        if (curso.isPresent()) {
            // Si el curso existe, se retorna un código de estado 200 (OK) y el curso.
            // ok() construye una respuesta con el código de estado 200.
            // Dentro de ok() se puede pasar el objeto que se quiere devolver en la respuesta.
            return Response.ok(curso.get()).build();
        }

        // Si el curso no existe, se retorna un código de estado 404 (NOT FOUND).
        // Se construye una respuesta con el código de estado 404.
        // build() construye la respuesta.
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    // La anotación @Consumes indica que el método crear recibe un objeto en formato XML.
    // Si se recibe un objeto en formato JSON, se debe cambiar MediaType.APPLICATION_XML por MediaType.APPLICATION_JSON.
//    @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso) {
        try {
            Curso cursoGuardado = cursoService.guardar(curso);
            return Response.ok(cursoGuardado).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Si ocurre un error al guardar el curso, se retorna un código de estado 500 (INTERNAL SERVER ERROR).
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(@PathParam("id") Long id, Curso curso) {
        Optional<Curso> cursoExistente = cursoService.porId(id);

        if (cursoExistente.isPresent()) {
            curso.setId(id);
            try {
                Curso cursoActualizado = cursoService.guardar(curso);
                return Response.ok(cursoActualizado).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        Optional<Curso> curso = cursoService.porId(id);

        if (curso.isPresent()) {
            try {
                cursoService.eliminar(curso.get().getId());
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
