package org.tucno.apiservlet.webapp.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/register") // La URL a la que se mapea el servlet es http://localhost:8080/webapp-form/register
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html");

        // Se obtienen los parámetros del formulario
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String country = req.getParameter("country");
        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        boolean enable = req.getParameter("enable") != null && req.getParameter("enable").equals("on");
        String secret = req.getParameter("secret");

        // Validación de los campos del formulario
        Map<String, String> errors = new HashMap<>();
        if (username == null || username.isBlank()) {
            errors.put("username" ,"El campo username es obligatorio");
        }
        if (email == null || !email.contains("@")) {
            errors.put("email" ,"El campo email es obligatorio");
        }
        if (password == null || password.isBlank()) {
            errors.put("password" ,"El campo password es obligatorio");
        }
        if (country == null || country.isBlank()) {
            errors.put("country" ,"El campo country es obligatorio");
        }

        StringBuilder lenguajesStr = new StringBuilder();
        if (lenguajes == null || lenguajes.length == 0) {
            errors.put("lenguajes" ,"El campo lenguajes es obligatorio");
        } else {
            for (String lenguaje : lenguajes) {
                lenguajesStr.append("<li>").append(lenguaje).append("</li>\n");
            }
        }

        StringBuilder rolesStr = new StringBuilder();
        if (roles == null || roles.length == 0) {
            errors.put("roles" ,"El campo roles es obligatorio");
        } else {
            for (String rol : roles) {
                rolesStr.append("<li>").append(rol).append("</li>\n");
            }
        }
        if (idioma == null) {
            errors.put("idioma" ,"El campo idioma es obligatorio");
        }

        // Si no hay errores se muestra el resultado
        if (errors.isEmpty()) {
            // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
            try (PrintWriter out = resp.getWriter()) {
                // Se escribe el mensaje en la respuesta en formato HTML
                out.print(STR."""
                <!DOCTYPE html>
                <html lang="es">
                    <head>
                      <meta charset="UTF-8">
                      <meta name="viewport" content="width=device-width, initial-scale=1.0">
                      <title>Resultado Form</title>
                    </head>

                    <body>
                        <h1>Resultado Form</h1>

                        <ul>
                            <li>Username: \{username}</li>
                            <li>Email: \{email}</li>
                            <li>Password: \{password}</li>
                            <li>Country: \{country}</li>
                            <li>Lenguajes:
                                <ul>
                                    \{lenguajesStr}
                                </ul>
                            </li>
                            <li>Roles:
                                <ul>
                                    \{rolesStr}
                                </ul>
                            </li>
                            <li>Idioma: \{idioma}</li>
                            <li>Enable: \{enable}</li>
                            <li>Secret: \{secret}</li>
                        </ul>
                    </body>
                </html>
                """);
            }
        } else {
            // Se establece el atributo errors en la petición para mostrar los errores en el formulario
            req.setAttribute("errors", errors);
            // getServletContext() obtiene el contexto de la aplicación, esto sirve para obtener recursos de la aplicación como archivos JSP
            // getRequestDispatcher() obtiene un objeto RequestDispatcher que se utiliza para enviar la petición a otro recurso, en este caso a un archivo JSP
            // forward() envía la petición al recurso especificado, en este caso al archivo JSP index.jsp
            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
