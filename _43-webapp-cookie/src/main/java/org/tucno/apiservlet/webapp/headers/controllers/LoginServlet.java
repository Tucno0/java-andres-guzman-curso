package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.headers.services.LoginService;
import org.tucno.apiservlet.webapp.headers.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

@WebServlet({"/login", "/login.html"}) // http://localhost:8080/webapp-headers/login
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se obtiene la lista de cookies de la petición actual
        LoginService loginService = new LoginServiceImpl();
        Optional<String> usernameCookie = loginService.getUserName(req);

        if (usernameCookie.isPresent()) {
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
                      <title>Hola!!!! \{usernameCookie.get()}</title>

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
                            <p class="welcome-message">¡Bienvenido \{usernameCookie.get()}! ya has iniciado sesion anteriormente</p>
                            <a href="\{req.getContextPath()}/index.html">Volver</a>
                            <a href="\{req.getContextPath()}/logout">Cerrar sesión</a>
                        </div>
                    </body>
                </html>
                """);
            }
        } else { // Si no se encuentra la cookie de username, se redirige a la página de login
            // getRequestDispatcher() permite redirigir la petición a otro recurso de la aplicación
            // En este caso se redirige a la página de login que se encuentra en la carpeta webapp
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            // Se crea una cookie con el nombre de usuario
            Cookie usernameCookie = new Cookie("username", username);
            // Agregamos la cookie a la respuesta
            resp.addCookie(usernameCookie);

            // Se redirige a la página de login
            resp.sendRedirect(STR."\{req.getContextPath()}/login");
        } else {
            // Se envía un error 401 Unauthorized
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usted no tiene permisos para acceder a este recurso.");
        }
    }
}
