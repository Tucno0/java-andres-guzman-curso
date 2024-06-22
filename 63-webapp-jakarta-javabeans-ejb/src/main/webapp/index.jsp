<%--
  Created by IntelliJ IDEA.
  User: jhampier
  Date: 18/06/2024
  Time: 06:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>EJB</title>
    </head>

    <body>
        <h1>Test EJB</h1>
        <h3>
            ${saludo}
        </h3>
        <h3>
            ${saludo2}
        </h3>

        <ul>
            <c:forEach items="${listado}" var="prod">
                <li>${prod.nombre}</li>
            </c:forEach>
        </ul>

    </body>
</html>
