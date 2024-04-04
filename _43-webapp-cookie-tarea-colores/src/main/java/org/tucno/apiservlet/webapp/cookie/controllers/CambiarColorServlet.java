package org.tucno.apiservlet.webapp.cookie.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cambiar-color")
public class CambiarColorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtiene el color de la petición
        String color = req.getParameter("color");

        // Se establece el color en la cookie
        Cookie colorCookie = new Cookie("color", color);
        resp.addCookie(colorCookie);

        // Se redirige a la página de inicio
        resp.sendRedirect(STR."\{req.getContextPath()}/index.jsp");
    }
}
