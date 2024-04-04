package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.headers.models.Producto;
import org.tucno.apiservlet.webapp.headers.services.ProductoService;
import org.tucno.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/buscar-producto") // http://localhost:8080/webapp-headers/buscar-producto
public class BuscarProductoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();

        // Se obtiene el nombre del producto a buscar desde el formulario
        String nombreProducto = req.getParameter("nombre");

        // Se busca el producto por el nombre
        Optional<Producto> encontrado = productoService.buscarProducto(nombreProducto);

        if (encontrado.isPresent()) {
            // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
            resp.setContentType("text/html;charset=UTF-8");

            // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
            try (PrintWriter out = resp.getWriter()) {
                // Se escribe el mensaje en la respuesta en formato HTML
                out.print(STR."""
                <!DOCTYPE html>
                <html lang="es">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Producto Encontrado</title>
                    </head>
                    
                    <body>
                        <h1>Producto Encontrado</h1>

                        <p>Nombre: \{encontrado.get().getNombre()}</p>
                        <p>Precio: \{encontrado.get().getPrecio()}</p>
                        <p>Tipo: \{encontrado.get().getTipo()}</p>
                    </body>
                </html>
                """);
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, STR."Lo sentimos, el producto \{nombreProducto} no se encuentra en la base de datos");
        }
    }
}
