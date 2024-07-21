package org.tucno.clientews;

import org.tucno.webapp.jaxws.services.Curso;
import org.tucno.webapp.jaxws.services.CursoServicioWs;
import org.tucno.webapp.jaxws.services.CursoServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        // Se obtiene el servicio web a través de la clase ServicioWsImplService
        // Sirve para comunicarse con el servicio web publicado en el servidor
        CursoServicioWs service = new CursoServicioWsImplService().getCursoServicioWsImplPort();

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
