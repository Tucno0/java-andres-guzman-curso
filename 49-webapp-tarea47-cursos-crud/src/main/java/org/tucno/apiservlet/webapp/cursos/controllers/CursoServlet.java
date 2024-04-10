package org.tucno.apiservlet.webapp.cursos.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.cursos.models.Curso;
import org.tucno.apiservlet.webapp.cursos.services.CursoService;
import org.tucno.apiservlet.webapp.cursos.services.CursoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet({"/index.html", "/cursos"})
public class CursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("connection");

        CursoService cursoService = new CursoServiceImpl(connection);
        List<Curso> cursos = null;
        try {
            cursos = cursoService.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("titulo", "Listado de cursos");
        req.setAttribute("cursos", cursos);

        req.getRequestDispatcher("listar.jsp").forward(req, resp);
    }
}
