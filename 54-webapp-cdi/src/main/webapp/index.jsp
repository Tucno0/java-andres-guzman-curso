<jsp:include page="layout/header.jsp"/>
        <h3>${title}</h3>

        <ul class="list-group">
            <li class="list-group-item active">Menu de opciones</li>
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/login.html" class="footer__button">Login</a></li>
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/logout" class="footer__button">Logout</a></li>
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/productos" class="footer__button">Productos</a></li>
            <li class="list-group-item"><a href="${pageContext.request.contextPath}/carro/agregar" class="footer__button">Ver Carro</a></li>
        </ul>
<jsp:include page="layout/footer.jsp"/>
