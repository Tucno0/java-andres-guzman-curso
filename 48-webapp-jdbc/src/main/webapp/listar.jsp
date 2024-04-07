<%@ page import="org.tucno.apiservlet.webapp.jdbc.models.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
    String mensajeRequest = (String) request.getAttribute("mensaje");
    String mensajeApp = (String) getServletContext().getAttribute("mensaje");
%>

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

        <% if (username.isPresent()) { %>
        <button>Hola <%=username.get()%></button>
        <% } %>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Tipo</th>
                    <% if (username.isPresent()) { %>
                    <th>Precio</th>
                    <th>Agregar al carro</th>
                    <% } %>
                </tr>
            </thead>

            <tbody>
            <% for (Producto producto : productos) { %>
                <tr>
                    <td><%=producto.getId()%></td>
                    <td><%=producto.getNombre()%></td>
                    <td><%=producto.getTipo()%></td>
                    <td><%=producto.getPrecio()%></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/agregar-carro?id=<%=producto.getId()%>">Agregar al carro</a>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>

        <p><strong>Mensaje de la aplicación: </strong><%=mensajeApp%></p>
        <p><strong>Mensaje del request: </strong><%=mensajeRequest%></p>
    </body>
</html>
