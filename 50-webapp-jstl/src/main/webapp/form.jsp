<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--c de core--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

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
                        value="${producto.nombre}"
                        required
                    >
                </div>

                <c:if test="${errores != null && errores.containsKey('nombre')}">
                    <div style="color: red;">${errores.nombre}</div>
                </c:if>
            </div>

            <div>
                <label for="categoriaId">Categoria:</label>
                <div>
                    <select name="categoriaId" id="categoriaId">
                        <option value="">Seleccionar</option>

                        <c:forEach items="${categorias}" var="categoria">
                            <option
                                value="${categoria.id}"
                                ${categoria.id.equals(producto.categoria.id) ? "selected" : ""}
                            >
                                ${categoria.nombre}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <c:if test="${errores != null && errores.containsKey('categoriaId')}">
                    <div style="color: red;">${errores.categoriaId}</div>
                </c:if>
            </div>

            <div>
                <label for="precio">Precio:</label>
                <div>
                    <input
                        type="number"
                        id="precio"
                        name="precio"
                        value="${producto.precio > 0 ? producto.precio : ""}"
                        required
                    >
                </div>

                <c:if test="${errores != null && not empty errores.precio}">
                    <div style="color: red;">${errores.precio}</div>
                </c:if>
            </div>

            <div>
                <label for="sku">SKU:</label>
                <div>
                    <input
                        type="text"
                        id="sku"
                        name="sku"
                        value="${producto.sku}"
                        required
                    >
                </div>

                <c:if test="${errores != null && not empty errores.sku}">
                    <div style="color: red;">${errores.sku}</div>
                </c:if>
            </div>

            <div>
                <label for="fechaRegistro">Fecha de Registro:</label>
                <div>
                    <input
                            type="date"
                            id="fechaRegistro"
                            name="fechaRegistro"
                            value="${producto.fechaRegistro != null ? producto.fechaRegistro.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : ""}"
                            required
                    >
                </div>

                <c:if test="${errores != null && not empty errores.fechaRegistro}">
                    <div style="color: red;">${errores.fechaRegistro}</div>
                </c:if>
            </div>

            <input type="hidden" name="id" value="${producto.id}">

            <div>
                <button type="submit">
                    ${producto.id > 0 ? "Actualizar" : "Crear"}
                </button>
            </div>

        </form>
    </body>
</html>
