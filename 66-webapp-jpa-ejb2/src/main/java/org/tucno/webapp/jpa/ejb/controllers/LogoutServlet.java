package org.tucno.webapp.jpa.ejb.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.tucno.webapp.jpa.ejb.services.LoginService;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> usernameCookie = loginService.getUserName(req);

        // Si la cookie con el nombre de usuario existe, se elimina
        if (usernameCookie.isPresent()) {
            HttpSession session = req.getSession();
            // invalidate() invalida la sesión actual y elimina todos los atributos de la sesión
            session.invalidate();
        }

        // Se redirige al usuario a la página de login
        resp.sendRedirect("login.html");
    }
}
