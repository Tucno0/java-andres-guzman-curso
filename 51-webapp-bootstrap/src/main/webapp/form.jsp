<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--c de core--%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="layout/header.jsp"/>
        <h3>${title}</h3>

        <form action="${pageContext.request.contextPath}/productos/form" method="post" novalidate>
            <div class="row mb-2">
                <label class="col-form-label col-sm-2" for="nombre">Nombre:</label>
                <div class="col-sm-4">
                    <input
                        class="form-control"
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

            <div class="row mb-2">
                <label class="col-form-label col-sm-2" for="categoriaId">Categoria:</label>
                <div class="col-sm-4">
                    <select class="form-select" name="categoriaId" id="categoriaId">
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

            <div class="row mb-2">
                <label class="col-form-label col-sm-2" for="precio">Precio:</label>
                <div class="col-sm-4">
                    <input
                        class="form-control"
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

            <div class="row mb-2">
                <label class="col-form-label col-sm-2" for="sku">SKU:</label>
                <div class="col-sm-4">
                    <input
                        class="form-control"
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

            <div class="row mb-2">
                <label class="col-form-label col-sm-2" for="fechaRegistro">Fecha de Registro:</label>
                <div class="col-sm-4">
                    <input
                        class="form-control"
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
                <button type="submit" class="btn btn-primary">
                    ${producto.id > 0 ? "Actualizar" : "Crear [+]"}
                </button>
            </div>

        </form>
<jsp:include page="layout/footer.jsp"/>
