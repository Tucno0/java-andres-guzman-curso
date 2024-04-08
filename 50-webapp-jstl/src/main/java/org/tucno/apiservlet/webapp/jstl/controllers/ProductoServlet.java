package org.tucno.apiservlet.webapp.jstl.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.jstl.models.Producto;
import org.tucno.apiservlet.webapp.jstl.services.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

// Se establece la URL de la petición que va a ser atendida por el servlet
// En este caso se establece que el servlet atenderá las peticiones a las URL /productos.xls y /productos.html
@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar la conexión a la base de datos que se estableció en el filtro
        Connection connection = (Connection) req.getAttribute("connection");
        // Le pasamos la conexión a la implementación del servicio
        ProductoService productoService = new ProductoServiceJdbcImpl(connection);
        // Se obtiene la lista de productos
        List<Producto> productos = productoService.listar();

        // Se obtiene la lista de cookies de la petición actual
        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> usernameSession = loginService.getUserName(req);

        // Al request se le añade la lista de productos y el nombre de usuario
        req.setAttribute("productos", productos);
        req.setAttribute("username", usernameSession);
        // Se redirige a la vista listar.jsp
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req, resp);
    }
}
