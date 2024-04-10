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

@WebServlet("/cursos/buscar")
public class BuscarCursoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("connection");
        CursoService cursoService = new CursoServiceImpl(connection);
        String nombre = req.getParameter("nombre");

        List<Curso> cursos = null;
        try {
            cursos = cursoService.porNombre(nombre);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("titulo", "Resultado de la búsqueda");
        req.setAttribute("cursos", cursos);

        req.getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
