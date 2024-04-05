package org.tucno.apiservlet.webapp.listeners.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.listeners.models.Producto;
import org.tucno.apiservlet.webapp.listeners.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

// Se establece la URL de la petición que va a ser atendida por el servlet
// En este caso se establece que el servlet atenderá las peticiones a las URL /productos.xls y /productos.html
@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();

        // Se obtiene la lista de cookies de la petición actual
        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> usernameSession = loginService.getUserName(req);

        // Se obtiene el mensaje del request y de la aplicación
        // Estos mensajes fueron guardados en los listeners de la aplicación y del request
        // se crea en cada request y se destruye al finalizar
        String mensajeRequest = (String) req.getAttribute("mensaje");
        // se crea una sola vez en el AplicacionListener
        String mensajeApp = (String) req.getServletContext().getAttribute("mensaje");

        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");

        StringBuilder productosStr = new StringBuilder();
        productos.forEach(producto -> {
            productosStr.append(STR."""
                        <tr>
                            <td>\{producto.getId()}</td>
                            <td>\{producto.getNombre()}</td>
                            <td>\{producto.getTipo()}</td>
                            \{
                                usernameSession.isPresent()
                                    ? STR."""
                                        <td>\{producto.getPrecio()}</td>
                                        <td>
                                            <a href="\{req.getContextPath()}/agregar-carro?id=\{producto.getId()}">Agregar al carro</a>
                                        </td>
                                      """
                                    : ""
                            }
                        </tr>
            """);
        });

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try (PrintWriter out = resp.getWriter()) {
            // Se escribe el mensaje en la respuesta en formato HTML
            out.print(STR."""
            <!DOCTYPE html>
            <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Listado de Productos</title>

                  <style>
                    body {
                        width: 60%;
                        margin: 0 auto;
                        font-family: Arial, sans-serif;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                    }

                    th, td {
                        border: 1px solid #000;
                        padding: 8px;
                        text-align: left;
                    }

                    th {
                        background-color: #f2f2f2;
                    }

                    button {
                        margin-bottom: 20px;
                        background-color: #4CAF50;
                        border: none;
                        border-radius: 5px;
                        color: white;
                        padding: 15px 32px;
                        text-align: center;
                        text-decoration: none;
                        display: inline-block;
                        font-size: 16px;
                    }

                    button:hover {
                        background-color: #45a049;
                    }
                  </style>
                </head>

                <body>
                    <h1>Listado de Productos</h1>

                    \{usernameSession.map(s -> STR."<button>Hola \{s}</button>").orElse("")}

                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Tipo</th>
                                \{
                                    usernameSession.isPresent()
                                        ? STR."""
                                            <th>Precio</th>
                                            <th>Agregar al carro</th>
                                          """
                                        : ""
                                }
                            </tr>
                        </thead>
                        <tbody>
                            \{productosStr}
                        </tbody>
                    </table>

                    <p><strong>Mensaje de la aplicación: </strong>\{mensajeApp}</p>
                    <p><strong>Mensaje del request: </strong>\{mensajeRequest}</p>

                </body>
            </html>
            """);
        }
    }
}
