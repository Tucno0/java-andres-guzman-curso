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
import java.util.List;

// Se establece la URL de la petición que va a ser atendida por el servlet
// En este caso se establece que el servlet atenderá las peticiones a las URL /productos.xls y /productos.html
@WebServlet({"/productos.xls", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();

        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");

        String servletPath = req.getServletPath(); // Se obtiene la ruta del servlet, es decir, la URL del servlet. Ejem: /productos.xls o /productos.html
        boolean isXls = servletPath.endsWith(".xls"); // Se verifica si la petición es para exportar a Excel

        StringBuilder productosStr = new StringBuilder();
        productos.forEach(producto -> {
            productosStr.append(STR."""
                        <tr>
                            <td>\{producto.getId()}</td>
                            <td>\{producto.getNombre()}</td>
                            <td>\{producto.getTipo()}</td>
                            <td>\{producto.getPrecio()}</td>
                        </tr>
            """);
        });

        // Si la petición es para exportar a Excel
        if (isXls) {
            // Se establece el tipo de contenido de la respuesta, en este caso es un archivo Excel
            resp.setContentType("application/vnd.ms-excel");
            // Se establece el encabezado Content-Disposition para indicar que se va a descargar un archivo con el nombre productos.xls
            // content-disposition: es para indicar al navegador que debe descargar el archivo en lugar de mostrarlo
            // attachment: indica que el archivo debe ser descargado y no mostrado en el navegador
            resp.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try ( PrintWriter out = resp.getWriter() ) {
            // Se escribe el mensaje en la respuesta en formato HTML

            if (!isXls) {
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

                        <button onclick="location.href='\{req.getContextPath()}/productos.xls'">Exportar a Excel</button>
                        <button onclick="location.href='\{req.getContextPath()}/productos.json'">Ver en JSON</button>
                """);
            }

            out.print(STR."""
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Tipo</th>
                                <th>Precio</th>
                            </tr>
                        </thead>
                        <tbody>
                \{productosStr}
                        </tbody>
                    </table>
            """);

            if (!isXls) {
                out.print(STR."""
                    </body>
                </html>
                """);
            }

        }
    }
}
