<%--
  Created by IntelliJ IDEA.
  User: jhampier
  Date: 04/04/2024
  Time: 03:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Tarea 42</title>
    </head>
    <body>
        <h3>Tarea 5: Session HTTP</h3>
        <p>Hola <%=session.getAttribute("nombre") != null ? session.getAttribute("nombre"): "anónimo"%>, bienvenido a la tarea5.</p>

        <form action="${pageContext.request.contextPath}/guardar-session" method="post">
            <label for="nombre">Ingrese tu nombre de sesión:</label>

            <div>
                <input type="text" name="nombre" id="nombre">
            </div>

            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
