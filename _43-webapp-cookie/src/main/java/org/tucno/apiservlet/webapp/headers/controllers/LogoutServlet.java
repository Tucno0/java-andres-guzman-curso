package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.headers.services.LoginService;
import org.tucno.apiservlet.webapp.headers.services.LoginServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService loginService = new LoginServiceImpl();
        Optional<String> usernameCookie = loginService.getUserName(req);

        // Si la cookie con el nombre de usuario existe, se elimina
        if (usernameCookie.isPresent()) {
            // Se crea una cookie con el nombre de usuario y se establece su valor en vacío
            Cookie cookie = new Cookie("username", "");
            // Se establece la duración de la cookie en 0 segundos
            cookie.setMaxAge(0);
            // Se agrega la cookie a la respuesta
            resp.addCookie(cookie);
        }

        // Se redirige al usuario a la página de login
        resp.sendRedirect("login.html");
    }
}
