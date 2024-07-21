package org.tucno.webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.tucno.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

// La anotación @WebService indica que la clase ServicioWsImpl es un servicio web
// endpointInterface indica la interfaz que define los métodos del servicio web que se implementan en esta clase.
@WebService(endpointInterface = "org.tucno.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {
    private int contador;

    @Override
    // La anotación @WebMethod indica que el método saludar es un método de servicio web.
    // El método saludar recibe un parámetro de tipo String y devuelve un String.
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimiendo dentro del servicio web: " + this);
        contador++;
        System.out.println("El valor del contador dentro del metodo saludar es: " + contador);
        return "Hola " + persona + " (" + contador + ")";
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("Java"), new Curso("Python"), new Curso("JavaScript"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso creado: " + curso.getNombre());
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
