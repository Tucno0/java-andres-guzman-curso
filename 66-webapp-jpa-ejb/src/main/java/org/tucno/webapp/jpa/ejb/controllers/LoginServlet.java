package org.tucno.webapp.jpa.ejb.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.tucno.webapp.jpa.ejb.models.entities.Usuario;
import org.tucno.webapp.jpa.ejb.services.LoginService;
import org.tucno.webapp.jpa.ejb.services.UsuarioService;

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
                out.print("<!DOCTYPE html>");
                out.print("<html lang=\"es\">");
                out.print("<head>");
                out.print("<meta charset=\"UTF-8\">");
                out.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.print("<title>Hola!!!! " + usernameOptional.get() + "</title>");
                out.print("<style>");
                out.print(".login-success-container {");
                out.print("display: flex;");
                out.print("flex-direction: column;");
                out.print("align-items: center;");
                out.print("justify-content: center;");
                out.print("height: 100vh;");
                out.print("background-color: #f0f0f0;");
                out.print("}");
                out.print(".title {");
                out.print("color: #333;");
                out.print("font-size: 2rem;");
                out.print("margin-bottom: 1rem;");
                out.print("}");
                out.print(".welcome-message {");
                out.print("color: #333;");
                out.print("font-size: 1.5rem;");
                out.print("}");
                out.print("</style>");
                out.print("</head>");
                out.print("<body>");
                out.print("<div class=\"login-success-container\">");
                out.print("<h1 class=\"title\">Login Correcto</h1>");
                out.print("<p class=\"welcome-message\">¡Bienvenido " + usernameOptional.get() + "! ya has iniciado sesion anteriormente</p>");
                out.print("<a href=\"" + req.getContextPath() + "/index.jsp\">Volver</a>");
                out.print("<br>");
                out.print("<a href=\"" + req.getContextPath() + "/productos\">Ver productos</a>");
                out.print("<br>");
                out.print("<a href=\"" + req.getContextPath() + "/logout\">Cerrar sesión</a>");
                out.print("</div>");
                out.print("</body>");
                out.print("</html>");
            }
        } else { // Si no se encuentra la cookie de username, se redirige a la página de login
            req.setAttribute("title", req.getAttribute("title") + " - Login");
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
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            // Se envía un error 401 Unauthorized
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Usted no tiene permisos para acceder a este recurso.");
        }
    }
}
