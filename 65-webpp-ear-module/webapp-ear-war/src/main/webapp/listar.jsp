<%--
  Created by IntelliJ IDEA.
  User: jhampier
  Date: 23/06/2024
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <style>
            html {
                font-family: Arial, sans-serif;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            a {
                color: #4CAF50;
                text-decoration: none;
            }
            a:hover {
                color: #45a049;
            }
        </style>
    </head>

    <body>
    <h1>Listado de Personas</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Email</th>
            <th>Acciones</th>
        </tr>

        <c:forEach items="${usuarios}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.email}</td>
                <td>
                    <a href="editar?id=${u.id}">Editar</a> |
                    <a href="eliminar?id=${u.id}">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>