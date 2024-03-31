<%@page contentType="text/html; ISO-8859-1" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>

<%
    Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de usuarios</title>

    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous"
    >
</head>

<body class="container my-4">
    <h1 class="mb-4">Registrar producto</h1>

    <%
        // Si no hay errores, no se muestra el mensaje
        if ((errors != null) && (!errors.isEmpty())) {
    %>
        <div class="alert alert-danger mb-4" role="alert">
            <ul class="mb-0">
                <%
                    for (String error : errors.values()) {
                %>
                    <li><%= error %></li>
                <%
                    }
                %>
            </ul>
        </div>
    <%  } %>

    <form action="${pageContext.request.contextPath}/crear" method="post">
        <div class="row mb-3">
            <label for="name" class="form-label col-sm-2 col-2">Nombre</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" value="${param.name}">

                <%
                    if ((errors != null) && errors.containsKey("name")) {
                        out.print("<div class='text-danger'>" + errors.get("name") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="price" class="form-label col-sm-2">Precio</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="price" name="price" min="0" value="${param.price}">

                <%
                    if ((errors != null) && errors.containsKey("price")) {
                        out.print("<div class='text-danger'>" + errors.get("price") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="maker" class="form-label col-sm-2">Fabricante</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="maker" name="maker" value="${param.maker}">
                <%
                    if ((errors != null) && errors.containsKey("maker")) {
                        out.print("<div class='text-danger'>" + errors.get("maker") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="category" class="form-label col-sm-2">Categoría</label>

            <div class="col-sm-10">
                <select class="form-select" id="category" name="category">
                    <option value="">-- Seleccione una categoría --</option>
                    <option value="electronica" ${param.category.equals("electronica") ? "selected" : ""}>Electronica</option>
                    <option value="ropa" ${param.category.equals("ropa") ? "selected" : ""}>Ropa</option>
                    <option value="hogar" ${param.category.equals("hogar") ? "selected" : ""}>Hogar</option>
                    <option value="deportes" ${param.category.equals("deportes") ? "selected" : ""}>Deportes</option>
                </select>
                <%
                    if ((errors != null) && errors.containsKey("category")) {
                        out.print("<div class='text-danger'>" + errors.get("category") + "</div>");
                    }
                %>
            </div>
        </div>

        <button type="submit" class="btn btn-primary mt-4">Enviar</button>
    </form>
</body>
</html>