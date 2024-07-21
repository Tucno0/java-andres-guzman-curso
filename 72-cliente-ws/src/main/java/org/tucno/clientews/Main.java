package org.tucno.clientews;

import org.tucno.webapp.jaxws.services.Curso;
import org.tucno.webapp.jaxws.services.ServicioWs;
import org.tucno.webapp.jaxws.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        // Se obtiene el servicio web a través de la clase ServicioWsImplService
        // Sirve para comunicarse con el servicio web publicado en el servidor
        ServicioWs service = new ServicioWsImplService().getServicioWsImplPort();

        System.out.println("El saludo es: " + service.saludar("Mundo"));

        Curso curso = new Curso();
        curso.setNombre("Java");

        Curso respuesta = service.crear(curso);
        System.out.println("Curso creado: " + respuesta.getNombre());

        service.listar().forEach(c -> System.out.println("Curso: " + c.getNombre()));
    }
}
