
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Cookie colores</title>
    </head>

    <body>
        <h1 style="color: ${cookie.color.getValue()}">Cookie colores</h1>

        <p style="color: ${cookie.color.getValue()}">Este es un texto que cambia de color según las opciones</p>

        <form action="${pageContext.request.contextPath}/cambiar-color" method="get">
            <div>
                <label for="color">Color:</label>
                <select name="color" id="color">
                    <option value="blue">Azul</option>
                    <option value="red">Rojo</option>
                    <option value="green">Verde</option>
                    <option value="yellow">Amarillo</option>
                    <option value="gray">Gris</option>
                    <option value="aqua">Aqua</option>
                    <option value="coral">Coral</option>
                </select>
            </div>

            <div style="margin-top: 10px">
                <button type="submit" style="padding: 5px 10px; background-color: ${cookie.color.getValue()}; border: 1px solid #ccc; cursor: pointer">
                    Cambiar color
                </button>
            </div>
        </form>
    </body>
</html>
