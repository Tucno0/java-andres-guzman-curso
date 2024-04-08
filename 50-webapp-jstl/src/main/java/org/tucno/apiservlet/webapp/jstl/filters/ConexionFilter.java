package org.tucno.apiservlet.webapp.jstl.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.apiservlet.webapp.jstl.exceptions.ServiceJdbcException;
import org.tucno.apiservlet.webapp.jstl.utils.ConexionBaseDatos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// Se va a encargar de abrir y cerrar la conexión a la base de datos
// Se va a ejecutar en todas las peticiones
@WebFilter("/*")
public class ConexionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // filterChain es el siguiente filtro que se va a ejecutar
    // Con doFilter se ejecuta el siguiente filtro
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (Connection connection = ConexionBaseDatos.getConnection()) {
            // Si el autocommit está activado, lo desactivamos
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }

            try {
                // Pasamos la conexión de base de datos al siguiente filtro
                servletRequest.setAttribute("connection", connection);
                filterChain.doFilter(servletRequest, servletResponse);
                connection.commit();
            } catch (SQLException | ServiceJdbcException e) {
                // Si hay un error, hacemos un rollback
                connection.rollback();
                // Enviamos un error 500 al cliente
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
