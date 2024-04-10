<%@ page import="java.util.Map" %>
<%@ page import="org.tucno.apiservlet.webapp.cursos.models.Curso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
    Curso curso = (Curso) request.getAttribute("curso");
    String titulo = (String) request.getAttribute("titulo");
%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title><%=titulo%></title>
    </head>

    <body>
        <h1><%=titulo%></h1>
        <p><a href="<%=request.getContextPath()%>/cursos">volver</a></p>

        <form action="<%=request.getContextPath()%>/cursos/form" method="post">
            <div>
                <label for="nombre">Nombre</label>
                <div>
                    <input type="text" name="nombre" id="nombre" value="<%=curso.getNombre() != null? curso.getNombre(): ""%>">
                </div>

                <% if(errores != null && errores.containsKey("nombre")){%>
                    <div style="color:red;"><%=errores.get("nombre")%></div>
                <% } %>
            </div>

            <div>
                <label for="instructor">Instructor</label>
                <div>
                    <input type="text" name="instructor" id="instructor" value="<%=curso.getInstructor()!= null? curso.getInstructor(): ""%>">
                </div>

                <% if(errores != null && errores.containsKey("instructor")){%>
                    <div style="color:red;"><%=errores.get("instructor")%></div>
                <% } %>
            </div>

            <div>
                <label for="duracion">Duracion</label>
                <div>
                    <input type="text" name="duracion" id="duracion" value="<%=curso.getDuracion()!=null? curso.getDuracion():""%>">
                </div>

                <% if(errores != null && errores.containsKey("duracion")){%>
                    <div style="color:red;"><%=errores.get("duracion")%></div>
                <% } %>
            </div>

            <div>
                <label for="descripcion">Descripción</label>
                <div>
                    <textarea name="descripcion" id="descripcion"><%=curso.getDescripcion()!=null? curso.getDescripcion():""%></textarea>
                </div>

                <% if(errores != null && errores.containsKey("descripcion")){%>
                    <div style="color:red;"><%=errores.get("descripcion")%></div>
                <% } %>
            </div>

            <input type="hidden" name="id" value="<%=curso.getId()%>">

            <div><input type="submit" value="<%=(curso.getId()!=null && curso.getId()>0)? "Editar": "Crear"%>"></div>

        </form>
    </body>
</html>