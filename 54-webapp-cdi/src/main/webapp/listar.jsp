<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%--c de core--%>

<%--<%@include file="layout/header.jsp"%>--%>
<jsp:include page="layout/header.jsp"/>
        <h3>${title}</h3>

        <c:if test="${username.isPresent()}">
            <div class="alert alert-info">Hola ${username.get()}, bienvenido!</div>

            <p>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/productos/form">Agregar Producto [+]</a>
            </p>
        </c:if>

        <table class="table table-hover table-striped">
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
                                <a class="btn btn-sm btn-primary" href="${pageContext.request.contextPath}/carro/agregar?id=${producto.id}">Agregar al carro</a>
                            </td>
                            <td>
                                <a class="btn btn-sm btn-success" href="${pageContext.request.contextPath}/productos/form?id=${producto.id}">Editar</a>
                            </td>
                            <td>
                                <a
                                    class="btn btn-sm btn-danger"
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
<jsp:include page="layout/footer.jsp"/>