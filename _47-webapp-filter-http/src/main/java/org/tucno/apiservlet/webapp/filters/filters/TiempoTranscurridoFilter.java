package org.tucno.apiservlet.webapp.filters.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.util.logging.Logger;

@WebFilter(filterName = "TiempoTranscurridoFilter", urlPatterns = {"/*"})
public class TiempoTranscurridoFilter implements Filter {
    private static final Logger logger =  Logger.getLogger("TiempoTranscurridoFilter");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long inicio = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long fin = System.currentTimeMillis();
        long resultado = fin - inicio;

        // imprimimos en el logs o imprimir directamente en consola con System.out.println
        logger.info(STR."El tiempo de carga de ka pagina es de \{resultado} milisegundos");
    }
}
