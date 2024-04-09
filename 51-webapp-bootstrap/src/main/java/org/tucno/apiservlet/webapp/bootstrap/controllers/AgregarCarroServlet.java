package org.tucno.apiservlet.webapp.bootstrap.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.tucno.apiservlet.webapp.bootstrap.models.Carro;
import org.tucno.apiservlet.webapp.bootstrap.models.ItemCarro;
import org.tucno.apiservlet.webapp.bootstrap.models.Producto;
import org.tucno.apiservlet.webapp.bootstrap.services.ProductoService;
import org.tucno.apiservlet.webapp.bootstrap.services.ProductoServiceJdbcImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;
import java.util.logging.Logger;

// El name sirve para identificar el servlet en el web.xml
@WebServlet("/carro/agregar")
public class AgregarCarroServlet extends HttpServlet {
    private static final Logger logger =  Logger.getLogger("AgregarCarroServlet");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Recuperar la conexión a la base de datos que se estableció en el filtro
        Connection connection = (Connection) req.getAttribute("connection");
        // Le pasamos la conexión a la implementación del servicio
        ProductoService productoService = new ProductoServiceJdbcImpl(connection);

        // Obtenemos el id del carro desde el request
        Long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }

        if (id == 0L) {
            resp.sendRedirect(STR."\{req.getContextPath()}/carro/ver");
            return;
        }

        // Obtenemos el producto por el id
        Optional<Producto> producto = productoService.obtenerPorId(id);

        logger.info("Producto obtenido por id");
        // Si el producto existe, lo agregamos al carro
        if (producto.isPresent()) {
            // Creamos un item de carro con cantidad 1
            ItemCarro item = new ItemCarro(1, producto.get());
            // Obtenemos la sesion del request
            HttpSession session = req.getSession();
            Carro carro = (Carro) session.getAttribute("carro");

            // Agregamos el item al carro
            carro.addItem(item);

            logger.info("Producto agregado al carro");
        }

        // Redirigimos al carro
        resp.sendRedirect(STR."\{req.getContextPath()}/carro/ver");

//        // Enviamos el producto agregado al carro en formato JSON
//        resp.setContentType("application/json");
//        resp.getWriter().write(STR."{\n  \"isPresent\": \{producto.isPresent()}\n}");
    }
}
