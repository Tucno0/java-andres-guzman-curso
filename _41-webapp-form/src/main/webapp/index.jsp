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
    <h1 class="mb-4">Formulario de usuarios</h1>

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

    <form action="/webapp-form/register" method="post">
        <div class="row mb-3">
            <label for="username" class="form-label col-sm-2 col-2">Username</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" value="${param.username}">

                <%
                    if ((errors != null) && errors.containsKey("username")) {
                        out.print("<div class='text-danger'>" + errors.get("username") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="password" class="form-label col-sm-2">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" value="123456">

                <%
                    if ((errors != null) && errors.containsKey("password")) {
                        out.print("<div class='text-danger'>" + errors.get("password") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="email" class="form-label col-sm-2">Email</label>

            <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email" value="${param.email}">
                <%
                    if ((errors != null) && errors.containsKey("email")) {
                        out.print("<div class='text-danger'>" + errors.get("email") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="country" class="form-label col-sm-2">Country</label>

            <div class="col-sm-10">
                <select class="form-select" id="country" name="country">
                    <option value="">-- Seleccione un país --</option>
                    <option value="AR" ${param.country.equals("AR") ? "selected" : ""}>Argentina</option>
                    <option value="BR" ${param.country.equals("BR") ? "selected" : ""}>Brasil</option>
                    <option value="CL" ${param.country.equals("CL") ? "selected" : ""}>Chile</option>
                    <option value="CO" ${param.country.equals("CO") ? "selected" : ""}>Colombia</option>
                    <option value="EC" ${param.country.equals("EC") ? "selected" : ""}>Ecuador</option>
                    <option value="PE" ${param.country.equals("PE") ? "selected" : ""}>Perú</option>
                    <option value="UY" ${param.country.equals("UY") ? "selected" : ""}>Uruguay</option>
                </select>
                <%
                    if ((errors != null) && errors.containsKey("country")) {
                        out.print("<div class='text-danger'>" + errors.get("country") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label for="lenguajes" class="form-label col-sm-2">Lenguajes de programación</label>

            <div class="col-sm-10">
                <select class="form-select" multiple id="lenguajes" name="lenguajes" multiple>
                    <option
                        value="java"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("java")).get() ? "selected" : ""}
                    >
                        Java
                    </option>
                    <option
                        value="php"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("php")).get() ? "selected" : ""}
                    >
                        PHP
                    </option>
                    <option
                        value="python"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("python")).get() ? "selected" : ""}
                    >
                        Python
                    </option>
                    <option
                        value="javascript"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("javascript")).get() ? "selected" : ""}
                    >
                        JavaScript
                    </option>
                    <option
                        value="c"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("c")).get() ? "selected" : ""}
                    >
                        C
                    </option>
                    <option
                        value="c++"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("c++")).get() ? "selected" : ""}
                    >
                        C++
                    </option>
                    <option
                        value="c#"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("c#")).get() ? "selected" : ""}
                    >
                        C#
                    </option>
                    <option
                        value="ruby"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("ruby")).get() ? "selected" : ""}
                    >
                        Ruby
                    </option>
                    <option
                        value="go"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("go")).get() ? "selected" : ""}
                    >
                        Go
                    </option>
                    <option
                        value="kotlin"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("kotlin")).get() ? "selected" : ""}
                    >
                        Kotlin
                    </option>
                    <option
                        value="swift"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("swift")).get() ? "selected" : ""}
                    >
                        Swift
                    </option>
                    <option
                        value="rust"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("rust")).get() ? "selected" : ""}
                    >
                        Rust
                    </option>
                    <option
                        value="typescript"
                        ${paramValues.lenguajes.stream().anyMatch(v -> v.equals("typescript")).get() ? "selected" : ""}
                    >
                        TypeScript
                    </option>
                </select>

                <%
                    if ((errors != null) && errors.containsKey("lenguajes")) {
                        out.print("<div class='text-danger'>" + errors.get("lenguajes") + "</div>");
                    }
                %>
            </div>
        </div>

        <div class="row mb-3">
            <label class="form-label col-sm-2">Roles</label>

            <div class="col-sm-10">
                <div class="form-check-inline">
                    <input
                        class="form-check-input"
                        type="checkbox"
                        id="admin"
                        name="roles"
                        value="ROLE_ADMIN"
                        ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_ADMIN")).get() ? "checked" : ""}
                    >
                    <label class="form-check-label" for="admin">Admin</label>
                </div>

                <div class="form-check-inline">
                    <input
                        class="form-check-input"
                        type="checkbox"
                        id="user"
                        name="roles"
                        value="ROLE_USER"
                        ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_USER")).get() ? "checked" : ""}
                    >
                    <label class="form-check-label" for="user">User</label>
                </div>

                <div class="form-check-inline">
                    <input
                        class="form-check-input"
                        type="checkbox"
                        id="moderator"
                        name="roles"
                        value="ROLE_MODERATOR"
                        ${paramValues.roles.stream().anyMatch(v -> v.equals("ROLE_MODERATOR")).get() ? "checked" : ""}
                    >
                    <label class="form-check-label" for="moderator">Moderator</label>
                </div>

                <%
                    if ((errors != null) && errors.containsKey("roles")) {
                        out.print("<div class='text-danger'>" + errors.get("roles") + "</div>");
                    }
                %>
            </div>
        </div>

        <!-- radio de idiomas -->
        <div class="row mb-3">
            <label class="form-label col-sm-2">Idioma</label>

            <div class="col-sm-10">
                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="idioma" id="spanish" value="es" ${param.idioma.equals("es") ? "checked" : ""}>
                    <label class="form-check-label" for="spanish">
                        Spanish
                    </label>
                </div>

                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="idioma" id="english" value="en" ${param.idioma.equals("en") ? "checked" : ""}>
                    <label class="form-check-label" for="english">
                        English
                    </label>
                </div>

                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="idioma" id="portuguese" value="pt" ${param.idioma.equals("pt") ? "checked" : ""}>
                    <label class="form-check-label" for="portuguese">
                        Portuguese
                    </label>
                </div>

                <div class="form-check-inline">
                    <input class="form-check-input" type="radio" name="idioma" id="french" value="fr" ${param.idioma.equals("fr") ? "checked" : ""}>
                    <label class="form-check-label" for="french">
                        French
                    </label>
                </div>

                <%
                    if ((errors != null) && errors.containsKey("idioma")) {
                        out.print("<div class='text-danger'>" + errors.get("idioma") + "</div>");
                    }
                %>
            </div>

        </div>

        <div class="row mb-3">
            <label class="form-check-label col-sm-2" for="enable">Enable</label>

            <div class="col-sm-10">
                <div class="form-check form-switch">
                    <input class="form-check-input" type="checkbox" name="enable" role="switch" id="enable" checked>

                    <%
                        if ((errors != null) && errors.containsKey("enable")) {
                            out.print("<div class='text-danger'>" + errors.get("enable") + "</div>");
                        }
                    %>
                </div>
            </div>

        </div>

        <input type="hidden" name="secret" value="123465">

        <button type="submit" class="btn btn-primary mt-4">Enviar</button>
    </form>
</body>
</html>