package org.tucno.apiservlet.webapp.session.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guardar-session")
public class GuardarNombreSessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtiene la sesión actual
        HttpSession session = req.getSession();

        // Se obtiene el nombre del parámetro "nombre"
        String nombre = req.getParameter("nombre");

        // Se guarda el nombre en la sesión
        session.setAttribute("nombre", nombre);

        // Se redirige a la página de perfil-usuario
        resp.sendRedirect("perfil-usuario");
    }
}
