
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--c de core--%>

<%--Request Scope: Este es el alcance más corto, ya que se limita a una sola solicitud HTTP. Los atributos almacenados en este alcance solo están disponibles durante la solicitud actual. Los atributos se pueden establecer en este alcance utilizando el método setAttribute() de la clase HttpServletRequest. Los atributos se pueden recuperar en este alcance utilizando el método getAttribute() de la clase HttpServletRequest.--%>
<%--Session Scope: Este es el alcance de la sesión, ya que dura hasta que la sesión del usuario finaliza o caduca. Los atributos almacenados en este alcance están disponibles en todas las solicitudes HTTP realizadas por el usuario final durante la sesión actual. Los atributos se pueden establecer en este alcance utilizando el método setAttribute() de la clase HttpSession. Los atributos se pueden recuperar en este alcance utilizando el método getAttribute() de la clase HttpSession.--%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Carro de compras</title>
    </head>

    <body>
        <h1>Carro de compras</h1>

        <c:choose>
            <%--Si el carro es null o esta vacío--%>
            <c:when test="${sessionScope.carro == null || sessionScope.carro.items.isEmpty()}">
                <p>El carro de compras está vacío</p>
            </c:when>

            <%--Si el carro no es null y no esta vacío--%>
            <c:otherwise>
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
                            <c:forEach var="item" items="${sessionScope.carro.items}">
                                <tr>
                                    <td>${item.producto.id}</td>
                                    <td>${item.producto.nombre}</td>
                                    <td>${item.producto.precio}</td>

                                    <td>
                                        <input
                                            type="text"
                                            size="4"
                                            name="cant_${item.producto.id}"
                                            value="${item.cantidad}"
                                        />
                                    </td>

                                    <td>${item.importe}</td>

                                    <td>
                                        <input
                                            type="checkbox"
                                            value="${item.producto.id}"
                                            name="deleteProductos"
                                        />
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                        <tfoot>
                            <tr>
                                <td colspan="4" style="text-align: right;">Total:</td>
                                <td>${sessionScope.carro.total}</td>
                            </tr>
                        </tfoot>
                    </table>

                    <button type="submit">Actualizar carro</button>
                </form>
            </c:otherwise>
        </c:choose>

        <p>
            <a href="<%= request.getContextPath() %>/productos.html">Seguir comprando</a>
        </p>
        <p>
            <a href="<%= request.getContextPath() %>/index.html">Volver al inicio</a>
        </p>
    </body>
</html>
