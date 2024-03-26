package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se despacha la petición a la URL /cabeceras-request
        // Se reenvía la petición a otro servlet o recurso de la aplicación
        // No se envía la respuesta al cliente, sino que se reenvía la petición al recurso indicado
        // Manteniendo la URL en el navegador del cliente, es decir, no se cambia la URL en el navegador
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
    }
}
