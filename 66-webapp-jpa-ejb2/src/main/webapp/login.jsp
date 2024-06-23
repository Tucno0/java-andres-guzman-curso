<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp"/>
        <div class="login-container">
            <h3>${title}</h3>

            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="row my-2">
                    <label class="form-label" for="username">Username</label>
                    <div>
                        <input class="form-control" type="text" id="username" name="username" value="admin" required>
                    </div>
                </div>

                <div class="row my-2">
                    <label class="form-label" for="password">Password</label>
                    <div>
                        <input class="form-control" type="password" id="password" name="password" value="12345" required>
                    </div>
                </div>

                <button class="btn btn-primary" type="submit">Login</button>
            </form>
        </div>
<jsp:include page="layout/footer.jsp"/>
