
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.tucno.apiservlet.webapp.jdbc.models.*" %>

<%
    // Obtenemos el carro de la petición
    Carro carro = (Carro) session.getAttribute("carro");
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
<form name="formcarro" action="${pageContext.request.contextPath}/carro/actualizar" method="post">
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Cantidad</th>
            <th>Subtotal</th>
            <th>Borrar</th>
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
            <td><input type="text" size="4" name="cant_<%=item.getProducto().getId()%>" value="<%=item.getCantidad()%>" /></td>
            <td><%= item.getImporte() %></td>
            <td><input type="checkbox" value="<%=item.getProducto().getId()%>" name="deleteProductos" /></td>
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

    <button type="submit">Actualizar carro</button>
</form>
<% } %>

<p>
    <a href="<%= request.getContextPath() %>/productos.html">Seguir comprando</a>
</p>
<p>
    <a href="<%= request.getContextPath() %>/index.html">Volver al inicio</a>
</p>
</body>
</html>
