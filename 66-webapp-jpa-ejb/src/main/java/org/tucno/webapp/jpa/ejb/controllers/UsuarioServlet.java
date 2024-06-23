package org.tucno.webapp.jpa.ejb.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.tucno.webapp.jpa.ejb.models.entities.Usuario;
import org.tucno.webapp.jpa.ejb.services.LoginService;
import org.tucno.webapp.jpa.ejb.services.LoginServiceSessionImpl;
import org.tucno.webapp.jpa.ejb.services.UsuarioService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios")
public class UsuarioServlet extends HttpServlet {
    @Inject
    private UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> usuarios = usuarioService.listar();

        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = loginService.getUserName(req);

        req.setAttribute("usuarios", usuarios);
        req.setAttribute("username", usernameOptional);

        req.setAttribute("title", req.getAttribute("title") + " - Listado de usuarios");
        getServletContext().getRequestDispatcher("/usuarios/listar.jsp").forward(req, resp);
    }
}
