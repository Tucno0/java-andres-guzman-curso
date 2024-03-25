package org.tucno.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

// La URL a la que se mapea el servlet es http://localhost:8080/webapp/parametros/url-get
@WebServlet("/parametros/url-get")
public class _02_ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html");

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        PrintWriter out = resp.getWriter();

        // Se obtiene el valor del parámetro de la URL (query string) en este caso (?saludo=Hola)
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        String mensajeSaludo = (saludo != null && nombre != null)
                                    ? STR."El saludo enviado es: \{saludo} \{nombre}"
                                    : (saludo != null)
                                        ? STR."El saludo enviado es: \{saludo}"
                                        : (nombre != null)
                                            ? STR."El nombre enviado es: \{nombre}"
                                            : "No se ha enviado ningún parámetro en la URL";

        String mensajeCodigo = "";
        try {
            Integer codigo = Integer.parseInt(req.getParameter("codigo"));
            mensajeCodigo = STR."El código enviado es: \{codigo}";
        } catch (NumberFormatException e) {
            mensajeCodigo = "No se ha enviado ningún código en la URL";
        }

        out.print(STR."""
        <!DOCTYPE html>
        <html lang="es">
            <head>
              <meta charset="UTF-8">
              <meta name="viewport" content="width=device-width, initial-scale=1.0">
              <title>Parámetros GET de la url</title>
            </head>

            <body>
                <h1>Parámetros GET de la url</h1>

                <h2>\{mensajeSaludo}</h2>
                <h2>\{mensajeCodigo}</h2>
            </body>
        </html>
        """);

        out.close(); // Se cierra el objeto PrintWriter
    }
}
