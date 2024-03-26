package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirigir") // http://localhost:8080/webapp-headers/redirigir
public class RedirigirServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PRIMERA FORMA DE REDIRECCIONAR
        // Location es una cabecera de respuesta que indica la URL a la que se redirigirá el cliente
//        resp.setHeader("Location", "https://www.google.com");
        // Se establece el código de estado 302 que indica que la petición se ha redirigido
//        resp.setStatus(HttpServletResponse.SC_FOUND);

        // SEGUNDA FORMA DE REDIRECCIONAR
        // Se redirige al cliente a la URL indicada
        resp.sendRedirect(STR."\{req.getContextPath()}/productos.html");
    }
}
