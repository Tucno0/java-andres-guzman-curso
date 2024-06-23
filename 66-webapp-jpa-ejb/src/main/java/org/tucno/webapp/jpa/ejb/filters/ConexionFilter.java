package org.tucno.webapp.jpa.ejb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.webapp.jpa.ejb.exceptions.ServiceJdbcException;

import java.io.IOException;

// Se va a encargar de abrir y cerrar la conexión a la base de datos
// Se va a ejecutar en todas las peticiones
@WebFilter("/*")
public class ConexionFilter implements Filter {
    /*@Inject // Inyectamos la conexión a la base de datos con CDI
//    @Named("connection") // Le damos un nombre a la conexión
    @MysqlConnection // Se utiliza la anotación personalizada MysqlConnection para calificar la conexión
    private Connection connection;*/

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    // filterChain es el siguiente filtro que se va a ejecutar
    // Con doFilter se ejecuta el siguiente filtro
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//            Connection connection = ConexionBaseDatos.getConnection(); // Conexión a la base de datos sin DataSource
//            Connection connection = ConexionBaseDatosDS.getConnection(); // Conexión a la base de datos con DataSource (JNDI) y pool de conexiones
//            Connection connection = this.connection; // Conexión a la base de datos con CDI
        /*try {
            Connection connection = this.connection;
            // Si el autocommit está activado, lo desactivamos
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }*/

            try {
                // Pasamos la conexión de base de datos al siguiente filtro
                filterChain.doFilter(servletRequest, servletResponse);
//                connection.commit();
            } catch (ServiceJdbcException e) {
                // Si hay un error, hacemos un rollback
//                connection.rollback();
                // Enviamos un error 500 al cliente
                ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
                e.printStackTrace();
            }

        /*} catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
