package org.tucno.apiservlet.webapp.jpa.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.tucno.apiservlet.webapp.jpa.models.entities.Usuario;
import org.tucno.apiservlet.webapp.jpa.services.LoginService;
import org.tucno.apiservlet.webapp.jpa.services.UsuarioService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"}) // http://localhost:8080/webapp-headers/login
public class LoginServlet extends HttpServlet {
    @Inject
    private UsuarioService usuarioService;

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<String> usernameOptional = loginService.getUserName(req);

        if (usernameOptional.isPresent()) {
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
                      <title>Hola!!!! \{usernameOptional.get()}</title>

                      <style>
                        .login-success-container {
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            justify-content: center;
                            height: 100vh;
                            background-color: #f0f0f0;
                        }

                        .title {
                            color: #333;
                            font-size: 2rem;
                            margin-bottom: 1rem;
                        }

                        .welcome-message {
                            color: #333;
                            font-size: 1.5rem;
                        }
                      </style>
                    </head>

                    <body>
                        <div class="login-success-container">
                            <h1 class="title">Login Correcto</h1>
                            <p class="welcome-message">¡Bienvenido \{usernameOptional.get()}! ya has iniciado sesion anteriormente</p>
                            <a href="\{req.getContextPath()}/index.jsp">Volver</a>
                            <br>
                            <a href="\{req.getContextPath()}/productos">Ver productos</a>
                            <br>
                            <a href="\{req.getContextPath()}/logout">Cerrar sesión</a>
                        </div>
                    </body>
                </html>
                """);
            }
        } else { // Si no se encuentra la cookie de username, se redirige a la página de login
            req.setAttribute("title", STR."\{req.getAttribute("title")} - Login");
            // getRequestDispatcher() permite redirigir la petición a otro recurso de la aplicación
            // En este caso se redirige a la página de login que se encuentra en la carpeta webapp
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Usuario> usuarioOptional = usuarioService.login(username, password);

        if (usuarioOptional.isPresent()) {
            // HttpSession es una interfaz que proporciona una forma de identificar a un usuario en la aplicación web
            // getSession() permite obtener la sesión actual o crear una nueva si no existe
            HttpSession session = req.getSession();
            // con setAttribute() se pueden guardar atributos en la sesión actual
            session.setAttribute("username", username);

            // Se redirige a la página de login
            resp.sendRedirect(STR."\{req.getContextPath()}/login");
        } else {
            // Se envía un error 401 Unauthorized
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usted no tiene permisos para acceder a este recurso.");
        }
    }
}
