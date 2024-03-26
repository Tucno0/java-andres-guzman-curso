package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login") // http://localhost:8080/webapp-headers/login
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
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
                      <title>Login Correcto</title>

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
                            <p class="welcome-message">¡Bienvenido \{username}!</p>
                        </div>
                    </body>
                </html>
                """);
            }
        } else {
            // Se envía un error 401 Unauthorized
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usted no tiene permisos para acceder a este recurso.");
        }
    }
}
