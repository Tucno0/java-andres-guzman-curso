package org.tucno.apiservlet.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.headers.models.Producto;
import org.tucno.apiservlet.webapp.headers.services.ProductoService;
import org.tucno.apiservlet.webapp.headers.services.ProductoServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos.json")
public class ProductoJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();

        // ObjectMapper es una clase de la librería Jackson que permite convertir objetos Java a JSON y viceversa
        ObjectMapper objectMapper = new ObjectMapper();
        // Se convierte la lista de productos a formato JSON y se almacena en la variable productosJson
        String productosJson = objectMapper.writeValueAsString(productos);

        // Se establece el tipo de contenido de la respuesta, en este caso es un texto JSON
        resp.setContentType("application/json");

        // Le enviamos la respuesta al cliente con la lista de productos en formato JSON
        resp.getWriter().print(productosJson);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtiene el flujo de entrada de la petición HTTP
        ServletInputStream jsonStream = req.getInputStream();

        // ObjectMapper es una clase de la librería Jackson que permite convertir objetos Java a JSON y viceversa
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println(STR."jsonStream = \{jsonStream}");

        // Se convierte el flujo de entrada a un objeto Producto con el método readValue de ObjectMapper
        Producto producto = objectMapper.readValue(jsonStream, Producto.class);
        
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");
        
        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try ( PrintWriter out = resp.getWriter() ) {
            // Se escribe el mensaje en la respuesta en formato HTML
            out.print(STR."""
            <!DOCTYPE html>
            <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Detalle Producto desde JSON</title>
                  
                  <style>
                    .product-detail__title {
                        font-size: 2em;
                        color: #333;
                        text-align: center;
                        margin-bottom: 1em;
                    }

                    .product-detail__info {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        gap: 1em;
                    }

                    .product-detail__info__item {
                        font-size: 1.2em;
                        color: #666;
                    }
                  </style>
                </head>
                
                <body>
                    <h1 class="product-detail__title">Detalle Producto desde JSON</h1>
                    
                    <div class="product-detail__info">
                        <div class="product-detail__info__item">
                            <strong>Modelo:</strong> \{producto.getId()}<br>
                        </div>
                        <div class="product-detail__info__item">
                            <strong>Nombre:</strong> \{producto.getNombre()}<br>
                        </div>
                        <div class="product-detail__info__item">
                            <strong>Precio:</strong> \{producto.getPrecio()}<br>
                        </div>
                        <div class="product-detail__info__item">
                            <strong>Marca:</strong> \{producto.getTipo()}<br>
                        </div>
                    </div>
                </body>
            </html>
            """);
        }
    }
}
