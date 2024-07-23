package org.tucno.cliente.jaxrs.jaas;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.internal.BasicAuthentication;
import org.tucno.cliente.jaxrs.jaas.models.Curso;
import org.tucno.cliente.jaxrs.jaas.models.Instructor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Client es la clase que se utiliza para crear una instancia de un cliente JAX-RS.
        // ClientBuilder es una clase que se utiliza para crear una instancia de Client.
        Client client = ClientBuilder.newClient();

        // WebTarget es una clase que se utiliza para construir una URL de destino para una solicitud.
        WebTarget rootUri = client.target("http://localhost:8080/webapp-jaxrs-jaas/api").path("/cursos");

        // Se crea un objeto BasicAuthentication para autenticar al usuario.
        rootUri.register(new BasicAuthentication("admin", "123456"));

        System.out.println("========== Curso por ID ==========");
        Response response = rootUri.path("/2").request(MediaType.APPLICATION_JSON).get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println("curso = " + curso);

        System.out.println("response.getStatus() = " + response.getStatus());
        System.out.println("response.getStatusInfo() = " + response.getStatusInfo());
        System.out.println("response.getHeaders() = " + response.getHeaders());

        System.out.println("\n========== Listar cursos ==========");
        listar(rootUri);

        System.out.println("\n========== Crear curso ==========");
        Instructor instructor = new Instructor();
        instructor.setId(2L);
        instructor.setNombre("Andres");
        instructor.setApellido("Guzman");

        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre("Java EE");
        nuevoCurso.setDescripcion("Curso de Java EE");
        nuevoCurso.setInstructor(instructor);
        nuevoCurso.setDuracion(108D);

        // Entity es una clase que se utiliza para construir una entidad que se envía en una solicitud.
        Entity<Curso> entityHeader = Entity.entity(nuevoCurso, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);

        System.out.println("curso = " + curso);
        listar(rootUri);

        System.out.println("\n========== Editar curso ==========");
        Curso cursoEditado = curso;
        cursoEditado.setNombre("Microservicios con Spring Boot");
        entityHeader = Entity.entity(cursoEditado, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/" + curso.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(entityHeader, Curso.class);

        System.out.println("curso editado = " + curso);
        listar(rootUri);

        System.out.println("\n========== Eliminar curso ==========");
        Response deleteResponse = rootUri.path("/" + curso.getId())
                .request(MediaType.APPLICATION_JSON)
                .delete();

        listar(rootUri);

    }

    private static void listar(WebTarget rootUri) {
        System.out.println("\n========== Lista Actualizada!! ==========");
        List<Curso> cursos = rootUri.request(MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Curso>>(){}); // Se debe especificar el tipo de la lista.
        cursos.forEach(System.out::println);
    }
}
