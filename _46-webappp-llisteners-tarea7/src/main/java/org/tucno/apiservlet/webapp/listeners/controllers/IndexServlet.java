package org.tucno.apiservlet.webapp.listeners.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreCompleto = (String) req.getAttribute("nombreCompleto");

        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try ( PrintWriter out = resp.getWriter() ) {
            // Se escribe el mensaje en la respuesta en formato HTML
            out.print(STR."""
            <!DOCTYPE html>
            <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Listeners</title>
                </head>
                
                <body>
                    <h1>Tarea 7: Listeners</h1>
                    <p>Mi nombre es \{nombreCompleto}!!!</p>
                </body>
            </html>
            """);
        }
    }
}
