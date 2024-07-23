package org.tucno.cliente.ws.jpa.jaas;

import jakarta.xml.ws.BindingProvider;
import org.tucno.webapp.jaxws.jaas.services.Curso;
import org.tucno.webapp.jaxws.jaas.services.CursoServicioWs;
import org.tucno.webapp.jaxws.jaas.services.CursoServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        // Se obtiene el servicio web a través de la clase ServicioWsImplService
        // Sirve para comunicarse con el servicio web publicado en el servidor
        CursoServicioWs service = new CursoServicioWsImplService().getCursoServicioWsImplPort();

        // Se configura el usuario y la contraseña para acceder al servicio web
        ((BindingProvider) service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider) service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "123456");

        Curso curso = new Curso();
        curso.setNombre("React");
        curso.setDescripcion("Curso de React");
        curso.setDuracion(50D);
        curso.setInstructor("Fernando Herrera");

        Curso respuesta = service.guardar(curso);

        System.out.println("Nuevo curso = " + curso.getId() + " - " + curso.getNombre());

        service.listar().forEach(c -> {
            System.out.println("Curso = " + c.getId() + " - " + c.getNombre());
        });
    }
}
