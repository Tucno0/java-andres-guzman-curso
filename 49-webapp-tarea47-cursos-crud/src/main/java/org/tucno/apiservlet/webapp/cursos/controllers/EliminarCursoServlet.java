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
import java.util.Optional;

@WebServlet("/cursos/eliminar")
public class EliminarCursoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("connection");
        CursoService cursoService = new CursoServiceImpl(connection);

        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id > 0) {
            Optional<Curso> curso = cursoService.porId(id);

            if (curso.isPresent()) {
                cursoService.eliminar(id);
                resp.sendRedirect(STR."\{req.getContextPath()}/cursos");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el curso en la base de datos");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "El id del curso es null, se debe enviar un id válido");
        }
    }
}
