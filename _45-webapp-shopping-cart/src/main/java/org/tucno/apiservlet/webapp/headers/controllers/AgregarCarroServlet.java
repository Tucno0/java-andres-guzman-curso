package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.tucno.apiservlet.webapp.headers.models.Carro;
import org.tucno.apiservlet.webapp.headers.models.ItemCarro;
import org.tucno.apiservlet.webapp.headers.models.Producto;
import org.tucno.apiservlet.webapp.headers.services.ProductoService;
import org.tucno.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.util.Optional;

// El name sirve para identificar el servlet en el web.xml
@WebServlet(name = "AgregarCarroServlet", value = "/agregar-carro")
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
            Carro carro;

            // Si no existe el carro en la sesion, lo creamos
            if (session.getAttribute("carro") == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            } else {
                // Si ya existe, lo obtenemos
                carro = (Carro) session.getAttribute("carro");
            }

            // Agregamos el item al carro
            carro.addItem(item);

        }

        // Redirigimos al carro
        resp.sendRedirect(STR."\{req.getContextPath()}/ver-carro");
    }
}
