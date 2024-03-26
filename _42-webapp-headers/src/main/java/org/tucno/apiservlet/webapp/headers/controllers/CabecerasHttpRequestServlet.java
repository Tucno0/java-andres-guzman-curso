package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request") // http://localhost:8080/webapp-headers/cabeceras-request
public class CabecerasHttpRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");

        String metodoHttp = req.getMethod(); // Se obtiene el método HTTP de la petición
        // Se obtiene la URI de la petición, es decir, la URL sin el host y el puerto. Ejem: /webapp-headers/cabeceras-request
        String uri = req.getRequestURI();
        String url = req.getRequestURL().toString(); // Se obtiene la URL completa de la petición
        String contexPath = req.getContextPath(); // Se obtiene el contexto de la aplicación, es decir, el nombre de la aplicación
        String servletPath = req.getServletPath(); // Se obtiene la ruta del servlet, es decir, la URL del servlet. Ejem: /cabeceras-request

        // Diferencia entre getLocalAddr() y getRemoteAddr()
        // getLocalAddr() devuelve la dirección IP del servidor
        // getRemoteAddr() devuelve la dirección IP del cliente que realizó la petición
        String ip = req.getLocalAddr(); // Se obtiene la dirección IP del cliente que realizó la petición
        String ipClient = req.getRemoteAddr(); // Se obtiene la dirección IP del cliente que realizó la petición
        int port = req.getLocalPort(); // Se obtiene el puerto del cliente que realizó la petición
        String host = req.getHeader("host"); // Se obtiene el valor de la cabecera Host de la petición (nombre del host y puerto)
        String userAgent = req.getHeader("User-Agent"); // Se obtiene el valor de la cabecera User-Agent de la petición
        String serverName = req.getServerName(); // Se obtiene el nombre del servidor
        String scheme = req.getScheme(); // Se obtiene el protocolo de la petición, es decir, http o https según corresponda

        String urlBase = STR."\{scheme}://\{host}\{contexPath}"; // Se construye la URL base de la aplicación
        String urlServlet = STR."\{scheme}://\{host}\{contexPath}\{servletPath}"; // Se construye la URL del servlet
        String urlIp = STR."\{scheme}://\{ip}:\{port}\{contexPath}\{servletPath}"; // Se construye la URL con la IP del cliente

        // Se obtienen los nombres de las cabeceras de la petición HTTP
        Enumeration<String> headerNames = req.getHeaderNames();

        StringBuilder headerNamesStr = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            headerNamesStr.append(STR."<li>\{header}: \{req.getHeader(header)}</li>\n\t\t\t");
        }

        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try ( PrintWriter out = resp.getWriter() ) {
            // Se escribe el mensaje en la respuesta en formato HTML
            out.print(STR."""
            <!DOCTYPE html>
            <html lang="es">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Cabeceras HTTP Request</title>
                </head>
                
                <body>
                    <h1>Cabeceras HTTP Request</h1>
                    <ul>
                        <li><strong>Método HTTP:</strong> \{metodoHttp}</li>
                        <li><strong>URI:</strong> \{uri}</li>
                        <li><strong>URL:</strong> \{url}</li>
                        <li><strong>Context Path:</strong> \{contexPath}</li>
                        <li><strong>Servlet Path:</strong> \{servletPath}</li>
                        <br>
                        <li><strong>IP:</strong> \{ip}</li>
                        <li><strong>IP Cliente:</strong> \{ipClient}</li>
                        <li><strong>Puerto:</strong> \{port}</li>
                        <li><strong>Host:</strong> \{host}</li>
                        <li><strong>User-Agent:</strong> \{userAgent}</li>
                        <li><strong>Server Name:</strong> \{serverName}</li>
                        <li><strong>Scheme:</strong> \{scheme}</li>
                        <br>
                        <li><strong>URL Base:</strong> \{urlBase}</li>
                        <li><strong>URL Servlet:</strong> \{urlServlet}</li>
                        <li><strong>URL IP:</strong> \{urlIp}</li>
                    </ul>

                    <h2>Cabeceras HTTP</h2>
                    <ul>
                        \{headerNamesStr}
                    </ul>
                </body>
            </html>
            """);
        }
    }
}
