package org.tucno.apiservlet.webapp.auth.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.tucno.apiservlet.webapp.auth.models.Usuario;
import org.tucno.apiservlet.webapp.auth.services.UsuarioService;
import org.tucno.apiservlet.webapp.auth.services.UsuarioServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/usuarios/form")
public class UsuarioFormServlet extends HttpServlet {
    @Inject
    private UsuarioService usuarioService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0;
        }

        Usuario usuario = new Usuario();

        if (id > 0) {
            Optional<Usuario> usuarioOptional = usuarioService.porId(id);
            if (usuarioOptional.isPresent()) {
                usuario = usuarioOptional.get();
            }
        }

        req.setAttribute("usuario", usuario);
        req.setAttribute("title", STR."\{req.getAttribute("title")} - Registro de usuario");

        getServletContext().getRequestDispatcher("/usuarios/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            errores.put("username", "El username es requerido!");
        }

        if ((id == 0) && (password == null || password.isBlank())) {
            errores.put("password", "El password es requerido!");
        }

        if (email == null || email.isBlank()) {
            errores.put("email", "El email es requerido!");
        }

        Usuario usuario = new Usuario();

        if (id > 0) {
            Optional<Usuario> o = usuarioService.porId(id);
            if (o.isPresent()) {
                usuario = o.get();
            }
        }

        usuario.setEmail(email);
        usuario.setUsername(username);

        if (password != null && !password.isBlank()) {
            usuario.setPassword(password);
        }

        if (errores.isEmpty()) {
            usuarioService.guardar(usuario);
            resp.sendRedirect(STR."\{req.getContextPath()}/usuarios");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("usuario", usuario);
            req.setAttribute("title", STR."\{req.getAttribute("title")} - Formulario de usuario");
            getServletContext().getRequestDispatcher("/usuarios/form.jsp").forward(req, resp);
        }
    }
}
