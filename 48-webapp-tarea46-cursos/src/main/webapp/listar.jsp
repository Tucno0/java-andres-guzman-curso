<%@ page import="java.util.List" %>
<%@ page import="org.tucno.apiservlet.webapp.cursos.models.Curso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String titulo = (String) request.getAttribute("titulo");
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
%>

<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title><%=titulo%></title>
    </head>

    <body>
        <h1><%=titulo%></h1>

        <form action="<%=request.getContextPath()%>/cursos/buscar" method="post">
            <input type="text" name="nombre">
            <input type="submit" value="Buscar">
        </form>

        <table>
            <tr>
                <th style="padding: 0 8px 0">Id</th>
                <th style="padding: 0 8px 0">Nombre</th>
                <th style="padding: 0 8px 0">Instructor</th>
                <th style="padding: 0 8px 0">Duracion</th>
            </tr>

            <% for(Curso c: cursos){%>
                <tr>
                    <td style="padding: 0 8px 0"><%=c.getId()%></td>
                    <td style="padding: 0 8px 0"><%=c.getNombre()%></td>
                    <td style="padding: 0 8px 0"><%=c.getInstructor()%></td>
                    <td style="padding: 0 8px 0"><%=c.getDuracion()%></td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
