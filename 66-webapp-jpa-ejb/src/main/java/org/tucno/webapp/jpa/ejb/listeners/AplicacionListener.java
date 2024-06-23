package org.tucno.webapp.jpa.ejb.listeners;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.logging.Logger;

// ServletContextListener es una interfaz que permite a los desarrolladores recibir notificaciones sobre cambios en el ciclo de vida del contexto general de la aplicación web.
// Mientras que ServletRequestListener es una interfaz que permite a los desarrolladores recibir notificaciones sobre cambios en el ciclo de vida de las solicitudes de los clientes.
// HttpSessionListener es una interfaz que permite a los desarrolladores recibir notificaciones sobre cambios en el ciclo de vida de las sesiones de los clientes.
// WebListener es una anotación que se utiliza para marcar una clase como un listener de eventos de la aplicación web.
@WebListener
public class AplicacionListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {
    private ServletContext servletContext;
    private static final Logger logger =  Logger.getLogger("AplicacionListener");

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // getServletContext() devuelve el objeto ServletContext asociado con esta aplicación web.
        // log() es un método que escribe un mensaje en el registro de la aplicación.
        sce.getServletContext().log("La aplicación web ha sido inicializada");
        // Se guarda el objeto ServletContext en una variable de instancia para poder acceder a él en otros métodos.
        servletContext = sce.getServletContext();

        servletContext.setAttribute("mensaje", "Algun valor global de la aplicación");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        servletContext.log("La aplicación web ha sido destruida");
    }


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        servletContext.log("Inicializando el request");
        sre.getServletRequest().setAttribute("mensaje", "Guardando algún valor en el request");
        sre.getServletRequest().setAttribute("title", "Catálogo Servlet");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        servletContext.log("Destruyendo el request");
    }


    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Ya no es necesario guardar el carro en la sesión, ya que se está utilizando un bean de sesión.
//        Carro carro = new Carro();
//        HttpSession session = se.getSession();
//        session.setAttribute("carro", carro);

        logger.info("Creando la sesión http");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        servletContext.log("Destruyendo la sesión http");
    }
}
