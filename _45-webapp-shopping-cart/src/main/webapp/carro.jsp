
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.tucno.apiservlet.webapp.headers.models.*" %>

<%
    // Obtenemos el carro de la petición
    Carro carro = (Carro) request.getAttribute("carro");
%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Carro de compras</title>
    </head>

    <body>
        <h1>Carro de compras</h1>

        <%  // Si el carro es null o esta vacío
            if (carro == null || carro.getItems().isEmpty()) {
        %>
            <p>El carro de compras está vacío</p>
        <%  } else { %>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                    </tr>
                </thead>
                <tbody>
                    <%  // Iteramos sobre los items del carro
                        for (ItemCarro item : carro.getItems()) {
                    %>
                        <tr>
                            <td><%= item.getProducto().getId() %></td>
                            <td><%= item.getProducto().getNombre() %></td>
                            <td><%= item.getProducto().getPrecio() %></td>
                            <td><%= item.getCantidad() %></td>
                            <td><%= item.getImporte() %></td>
                        </tr>
                    <% } %>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="4" style="text-align: right;">Total:</td>
                        <td><%= carro.getTotal() %></td>
                    </tr>
                </tfoot>
            </table>
        <% } %>

        <p>
            <a href="<%= request.getContextPath() %>/productos.html">Seguir comprando</a>
        </p>
        <p>
            <a href="<%= request.getContextPath() %>/index.html">Volver al inicio</a>
        </p>
    </body>
</html>
