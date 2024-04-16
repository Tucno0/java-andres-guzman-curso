package org.tucno.apiservlet.webapp.auth.controllers;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.auth.models.Producto;
import org.tucno.apiservlet.webapp.auth.services.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

// Se establece la URL de la petición que va a ser atendida por el servlet
// En este caso se establece que el servlet atenderá las peticiones a las URL /productos.xls y /productos.html
@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Inject
    @Named("default")
    private ProductoService productoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Se obtiene la lista de productos
        List<Producto> productos = productoService.listar();

        // Se obtiene la lista de cookies de la petición actual
        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> usernameSession = loginService.getUserName(req);

        // Al request se le añade la lista de productos y el nombre de usuario
        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameSession);
        req.setAttribute("title", STR."\{req.getAttribute("title")} - Listado de productos");
        // Se redirige a la vista listar.jsp
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
