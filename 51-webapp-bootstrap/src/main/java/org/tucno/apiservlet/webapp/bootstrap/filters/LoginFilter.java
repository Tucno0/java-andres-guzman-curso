package org.tucno.apiservlet.webapp.bootstrap.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.tucno.apiservlet.webapp.bootstrap.services.LoginService;
import org.tucno.apiservlet.webapp.bootstrap.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.util.Optional;

// Los filtros se utilizan para interceptar las peticiones y realizar acciones antes de que lleguen al servlet. Son como los Guards en Angular.
// En este caso, se intercepta la petición de login y se realiza una acción antes de que llegue al servlet
// WebFilter: Anotación que indica que la clase es un filtro
// filterName: Nombre del filtro
// urlPatterns: Patrones de URL que se van a filtrar (en este caso, las peticiones a /ver-carro y /agregar-carro)
// Se pueden agregar patrones de URL separados por comas, por ejemplo: urlPatterns = {"/carro/*", "/usuario/*"}
@WebFilter(filterName = "LoginFilter", urlPatterns = {"/carro/*", "/productos/form*", "/productos/form/*"})
public class LoginFilter implements Filter {
    @Override
    // Método que se ejecuta cuando se inicializa el filtro
    // Usualmente se utiliza para inicializar variables, cargar configuraciones, etc.
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    // Método que se ejecuta cuando se intercepta una petición
    // Se ejecuta antes de que la petición llegue al servlet
    // Se puede realizar acciones como validar la petición, modificarla, etc.
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService loginService = new LoginServiceSessionImpl();
        Optional<String> username = loginService.getUserName((HttpServletRequest) servletRequest);

        // Si el usuario no está logueado, se redirige a la página de login
        if (!username.isPresent()) {
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher("/login");
            requestDispatcher.forward(servletRequest, servletResponse);
            return;
        }

        // Si el usuario está logueado, se permite continuar con la petición
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    // Método que se ejecuta cuando se destruye el filtro
    // Usualmente se utiliza para liberar recursos, cerrar conexiones, etc.
    public void destroy() {
        Filter.super.destroy();
    }
}
