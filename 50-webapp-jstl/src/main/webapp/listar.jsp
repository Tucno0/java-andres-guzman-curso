<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--c de core--%>

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

        <c:if test="${username.isPresent()}">
            <%--Primera forma de mostrar el username:--%>
            <button>Hola ${username.get()}</button>

            <%--Segunda forma de mostrar el username:--%>
            <button>Hola <c:out value="${username.get()}"/></button>
            <p>
                <a href="${pageContext.request.contextPath}/productos/form">Agregar Producto [+]</a>
            </p>
        </c:if>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Tipo</th>

                    <c:if test="${username.present}">
                        <th>Precio</th>
                        <th>Agregar al carro</th>
                        <th>Editar</th>
                        <th>Eliminar</th>
                    </c:if>
                </tr>
            </thead>

            <tbody>
                <%--<% for (Producto producto : productos) { %>--%>
                <c:forEach items="${productos}" var="producto">
                    <tr>
                        <td><c:out value="${producto.id}"/></td>
                        <td><c:out value="${producto.nombre}"/></td>
                        <td><c:out value="${producto.categoria.nombre}"/></td>

                        <c:if test="${username.isPresent()}">
                            <td>${producto.precio}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/carro/agregar?id=${producto.id}">Agregar al carro</a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/productos/form?id=${producto.id}">Editar</a>
                            </td>
                            <td>
                                <a
                                    onclick="return confirm('¿Estás seguro de eliminar este producto?')"
                                    href="${pageContext.request.contextPath}/productos/eliminar?id=${producto.id}"
                                >
                                    Eliminar
                                </a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <p><strong>Mensaje de la aplicación: </strong>${applicationScope.mensaje}</p>
        <p><strong>Mensaje del request: </strong>${requestScope.mensaje}</p>
    </body>
</html>
