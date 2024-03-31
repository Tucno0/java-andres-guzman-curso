package org.tucno.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/crear")
public class RegistroProductoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Hacemos un forward a la vista del formulario
        getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html");

        // Se obtienen los parámetros del formulario
        String name = req.getParameter("name");
        String priceParam = req.getParameter("price");
        String maker = req.getParameter("maker");
        String category = req.getParameter("category");

        // Validación de los campos del formulario
        Map<String, String> errors = new HashMap<>();

        Integer price = null;
        if (priceParam != null && !priceParam.isBlank()) {
            try {
                price = Integer.parseInt(priceParam);
            } catch (NumberFormatException e) {
                errors.put("price", "El campo precio debe ser un número válido");
            }
        }

        if (price == null || price <= 0) {
            errors.put("price", "El campo precio es obligatorio y debe ser mayor a 0");
        }

        if (name == null || name.isBlank()) {
            errors.put("name", "El campo nombre es obligatorio");
        }

        if (maker == null || maker.isBlank()) {
            errors.put("maker", "El campo fabricante es obligatorio");
        }
        if (category == null || category.isBlank()) {
            errors.put("category", "El campo categoría es obligatorio");
        }

        // Si no hay errores se muestra el resultado
        if (errors.isEmpty()) {
            // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
            try ( PrintWriter out = resp.getWriter() ) {
                // Se escribe el mensaje en la respuesta en formato HTML
                out.print(STR."""
                <!DOCTYPE html>
                <html lang="es">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Producto registrado</title>
                    </head>

                    <body style="font-family: Arial, sans-serif; width: 80%; margin: 0 auto;">
                        <h1>Producto registrado</h1>

                        <div style="background-color: #f0f0f0; padding: 10px; margin: 10px;">
                            <p><strong>Nombre:</strong> \{name}</p>
                            <p><strong>Precio:</strong> \{price}</p>
                            <p><strong>Fabricante:</strong> \{maker}</p>
                            <p><strong>Categoría:</strong> \{category}</p>
                        </div>

                        <button style="padding: 10px; background-color: #f0f0f0; border: 1px solid #ccc; margin: 10px;">
                            <a href="/webapp-form-tarea/crear">Registra otro producto</a>
                        </button>
                    </body>
                </html>
                """);
            }
        } else {
            req.setAttribute("errors", errors);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req, resp);
        }
    }
}
