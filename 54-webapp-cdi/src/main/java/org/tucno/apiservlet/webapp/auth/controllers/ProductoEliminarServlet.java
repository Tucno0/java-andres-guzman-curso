package org.tucno.apiservlet.webapp.auth.controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.tucno.apiservlet.webapp.auth.configs.ProductoServicePrincipal;
import org.tucno.apiservlet.webapp.auth.models.Producto;
import org.tucno.apiservlet.webapp.auth.services.ProductoService;
import org.tucno.apiservlet.webapp.auth.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/productos/eliminar")
public class ProductoEliminarServlet extends HttpServlet {
    @Inject
    @ProductoServicePrincipal
    private ProductoService productoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id > 0) {
            Optional<Producto> productoOptional = productoService.obtenerPorId(id);

            if (productoOptional.isPresent()) {
                productoService.eliminar(id);
                resp.sendRedirect(STR."\{req.getContextPath()}/productos");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "El producto no existe en la base de datos");
            }

        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "El id del producto es requerido en la URL");
        }

    }
}
