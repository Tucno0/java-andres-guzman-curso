package org.tucno.webapp.tarea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/tarea1") // La URL a la que se mapea el servlet es http://localhost:8080/webapp/tarea1
public class Tarea38Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html");

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        PrintWriter out = resp.getWriter();

        // Se obtiene el valor del parámetro de la URL (query string)
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");

        String mensaje = (nombre != null && apellido != null)
                            ? STR."Mi nombre es \{nombre} \{apellido}"
                            : "No se ha enviado ningún parámetro en la URL";

        // fecha en formato (dd 'de' MMMM, yyyy)
         SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM, yyyy", new Locale("es", "ES"));
         String fecha = sdf.format(new Date());

        // Se escribe el mensaje en la respuesta en formato HTML
        out.print(STR."""
        <!DOCTYPE html>
        <html lang="es">
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1.0">
              <title>Tarea 1: Servlet y envío de parámetros</title>
            </head>
            
            <body>
                <h1>Tarea 1: Servlet y envío de parámetros</h1>
                <h2>\{mensaje}</h2>
                <h2> La fecha actual es: \{fecha}</h2>
            </body>
        </html>
        """);

        out.close(); // Se cierra el objeto PrintWriter
    }
}
