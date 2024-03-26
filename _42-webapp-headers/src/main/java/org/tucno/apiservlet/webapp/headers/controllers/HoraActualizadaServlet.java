package org.tucno.apiservlet.webapp.headers.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hora-actualizada")
public class HoraActualizadaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Se establece el tipo de contenido de la respuesta, en este caso es un texto HTML
        resp.setContentType("text/html;charset=UTF-8");

        // Se establece la cabecera Refresh con el valor 1, lo que indica que la página se refrescará cada 1 segundo
        resp.setHeader("Refresh", "1");

        LocalTime horaActual = LocalTime.now(); // Se obtiene la hora actual del sistema
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // Se crea un formato para la hora
        
        // Se obtiene el objeto PrintWriter para escribir la respuesta en el cuerpo de la respuesta
        try ( PrintWriter out = resp.getWriter() ) {
            // Se escribe el mensaje en la respuesta en formato HTML
            out.print(STR."""
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hora actualizada</title>
        <style>
            @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500&display=swap');

            body {
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                height: 100vh;
                font-family: 'Roboto', sans-serif;
                background: linear-gradient(to right, #1f4037, #99f2c8);
                transition: all 0.5s ease;
            }

            h1 {
                font-size: 2em;
                color: #fff;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
                position: absolute;
                top: 10%;
                left: 50%;
                transform: translate(-50%, -50%);
            }

            div {
                font-size: 10em;
                color: #fff;
                text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
                animation: fadeIn 2s ease-in-out infinite;
            }

            @keyframes fadeIn {
                0% {opacity: 0;}
                50% {opacity: 1;}
                100% {opacity: 0;}
            }
        </style>
    </head>
    <body>
        <h1>Hora actualizada</h1>
        <div>\{horaActual.format(formatter)}</div>
    </body>
</html>
            """);
        }
    }
}
