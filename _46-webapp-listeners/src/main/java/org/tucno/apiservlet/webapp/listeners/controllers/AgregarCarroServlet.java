package org.tucno.apiservlet.webapp.listeners.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.tucno.apiservlet.webapp.listeners.models.Carro;
import org.tucno.apiservlet.webapp.listeners.models.ItemCarro;
import org.tucno.apiservlet.webapp.listeners.models.Producto;
import org.tucno.apiservlet.webapp.listeners.services.ProductoService;
import org.tucno.apiservlet.webapp.listeners.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

// El name sirve para identificar el servlet en el web.xml
@WebServlet("/agregar-carro")
public class AgregarCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtenemos el id del carro desde el request
        Long id = Long.parseLong(req.getParameter("id"));

        // Obtenemos el producto por el id
        ProductoService productoService = new ProductoServiceImpl();
        Optional<Producto> producto = productoService.obtenerPorId(id);

        // Si el producto existe, lo agregamos al carro
        if (producto.isPresent()) {
            // Creamos un item de carro con cantidad 1
            ItemCarro item = new ItemCarro(1, producto.get());
            // Obtenemos la sesion del request
            HttpSession session = req.getSession();

            // Obtenemos el carro de la sesion, previamente creado en el AplicacionListener al crear la sesion
            Carro carro = (Carro) session.getAttribute("carro");

            // Agregamos el item al carro
            carro.addItem(item);
        }

        // Redirigimos al carro
        resp.sendRedirect( req.getContextPath() + "/ver-carro");

//        // Enviamos el producto agregado al carro en formato JSON
//        resp.setContentType("application/json");
//        resp.getWriter().write(STR."{\n  \"isPresent\": \{producto.isPresent()}\n}");
    }
}
