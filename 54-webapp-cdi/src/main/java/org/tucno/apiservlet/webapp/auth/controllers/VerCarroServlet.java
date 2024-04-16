package org.tucno.apiservlet.webapp.auth.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/carro/ver")
public class VerCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getServletContext() obtiene el contexto de la aplicación para poder redirigir a la página carro.jsp
        // el contexto de la aplicación es el directorio raíz de la aplicación web, por ejemplo, http://localhost:8080/webapp
        // getRequestDispatcher() obtiene un objeto RequestDispatcher para redirigir la petición a la página carro.jsp
        // forward() redirige la petición a la página carro.jsp para mostrar el contenido del carro

        // Se establece el título de la página
        req.setAttribute("title", STR."\{req.getAttribute("title")} - Carro de compras");
        getServletContext().getRequestDispatcher("/carro.jsp").forward(req, resp);
    }
}
