package org.tucno.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// WebServlet es una anotación que indica que la clase es un servlet y se mapea a la URL especificada
@WebServlet("/hola-mundo") // La URL a la que se mapea el servlet es http://localhost:8080/webapp/hola-mundo
public class _01_HolaMundoServlet extends HttpServlet {

    // Método que se ejecuta cuando se hace una petición GET
    // Recibe dos parámetros: la petición y la respuesta
    // request: contiene la información de la petición del cliente
    // response: contiene la información de la respuesta que se enviará al cliente
    // Se lanza una excepción ServletException si ocurre un error en la ejecución
    // Se lanza una excepción IOException si ocurre un error de entrada/salida
    // Se debe sobreescribir el método doGet de la clase HttpServlet, por eso se usa la anotación @Override
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        response.setContentType("text/html");
        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        PrintWriter out = response.getWriter();

        // Se escribe el mensaje en la respuesta en formato HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("       <title>Hola Mundo Servlet</title>");
        out.println("   </head>");

        out.println(    "<body>");
        out.println(        "<h1>Hola Mundo</h1>");
        out.println(        "<p>Este es un servlet que imprime un mensaje de Hola Mundo</p>");
        out.println(    "</body>");
        out.println("</html>");

        out.close(); // Se cierra el objeto PrintWriter
    }
}
