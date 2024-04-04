package org.tucno.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/perfil-usuario")
public class PerfilUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        // Se obtiene el atributo "nombre" de la sesión, se hace un cast a String
        String nombre = (String) session.getAttribute("nombre");

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
                  <title>Tarea 42</title>
                </head>

                <body>
                    <h1>Perfil de usuario \{nombre}</h1>
                    <li>Username: \{nombre}</li>

                    <a href="\{req.getContextPath()}">Volver a index</a>
                </body>
            </html>
            """);
        }
    }
}
