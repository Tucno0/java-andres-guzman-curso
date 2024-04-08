<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.tucno.apiservlet.webapp.jdbc.models.Categoria" %>
<%@ page import="org.tucno.apiservlet.webapp.jdbc.models.Producto" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");

    Producto producto = (Producto) request.getAttribute("producto");
    String fecha = producto.getFechaRegistro() != null ? producto.getFechaRegistro().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Formulario Producto</title>
    </head>

    <body>
        <h1>Formulario Producto</h1>
        <form action="${pageContext.request.contextPath}/productos/form" method="post" novalidate>
            <div>
                <label for="nombre">Nombre:</label>
                <div>
                    <input
                        type="text"
                        id="nombre"
                        name="nombre"
                        value="<%=producto.getNombre() != null ? producto.getNombre() : ""%>"
                        required
                    >
                </div>

                <% if (errores != null && errores.containsKey("nombre")) { %>
                    <div style="color: red;"><%= errores.get("nombre") %></div>
                <% } %>
            </div>

            <div>
                <label for="categoriaId">Categoria:</label>
                <div>
                    <select name="categoriaId" id="categoriaId">
                        <option value="">Seleccionar</option>
                        <% for (Categoria categoria : categorias) { %>
                            <option
                                value="<%=categoria.getId()%>"
                                <%=categoria.getId().equals(producto.getCategoria().getId()) ? "selected" : ""%>
                            >
                                <%= categoria.getNombre() %>
                            </option>
                        <% } %>
                    </select>
                </div>

                <% if (errores != null && errores.containsKey("categoriaId")) { %>
                    <div style="color: red;"><%= errores.get("categoriaId") %></div>
                <% } %>
            </div>

            <div>
                <label for="precio">Precio:</label>
                <div>
                    <input
                        type="number"
                        id="precio"
                        name="precio"
                        value="<%=producto.getPrecio() != null ? producto.getPrecio() : ""%>"
                        required
                    >
                </div>

                <% if (errores != null && errores.containsKey("precio")) { %>
                    <div style="color: red;"><%= errores.get("precio") %></div>
                <% } %>
            </div>

            <div>
                <label for="sku">SKU:</label>
                <div>
                    <input
                        type="text"
                        id="sku"
                        name="sku"
                        value="<%=producto.getSku() != null ? producto.getSku() : ""%>"
                        required
                    >
                </div>

                <% if (errores != null && errores.containsKey("sku")) { %>
                    <div style="color: red;"><%= errores.get("sku") %></div>
                <% } %>
            </div>

            <div>
                <label for="fechaRegistro">Fecha de Registro:</label>
                <div>
                    <input
                            type="date"
                            id="fechaRegistro"
                            name="fechaRegistro"
                            value="<%=fecha%>"
                            required
                    >
                </div>

                <% if (errores != null && errores.containsKey("fechaRegistro")) { %>
                    <div style="color: red;"><%= errores.get("fechaRegistro") %></div>
                <% } %>
            </div>

            <input type="hidden" name="id" value="<%=producto.getId() != null ? producto.getId() : ""%>">

            <div>
                <button type="submit">
                    <%=(producto.getId() != null && producto.getId() > 0) ? "Actualizar" : "Crear"%>
                </button>
            </div>

        </form>
    </body>
</html>
