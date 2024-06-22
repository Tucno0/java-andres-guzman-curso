package org.tucno.webpp.ejb.controllers;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.tucno.webpp.ejb.models.Producto;
import org.tucno.webpp.ejb.services.ServiceEjb;
import org.tucno.webpp.ejb.services.ServiceEjbLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet {

//    @EJB // Si inyectamos un EJB con @EJB, el contexto de @RequestScoped no se aplica
//    @Inject // cada vez que usamos CDI o contextos de inyección, usamos @Inject
//    private ServiceEjbLocal serviceEjb;

//    @EJB
//    @Inject
//    private ServiceEjbLocal serviceEjb2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceEjbLocal serviceEjbLocal = null;
        ServiceEjbLocal serviceEjb2Local = null;

        try {
            // InitialContext es una clase que nos permite acceder a los recursos de la aplicación en tiempo de ejecución
            InitialContext ctx = new InitialContext();
            // El método lookup nos permite buscar un recurso en el contexto de la aplicación por su nombre JNDI
            serviceEjbLocal = (ServiceEjb) ctx.lookup("java:global/webapp-jakarta-javabeans-ejb/ServiceEjb!org.tucno.webpp.ejb.services.ServiceEjbLocal");
            serviceEjb2Local = (ServiceEjb) ctx.lookup("java:global/webapp-jakarta-javabeans-ejb/ServiceEjb!org.tucno.webpp.ejb.services.ServiceEjbLocal");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("serviceEjb.equals(serviceEjb2) = " + serviceEjbLocal.equals(serviceEjb2Local)); // false

        Producto producto = serviceEjbLocal.crear(new Producto("Producto 4"));
        System.out.println("Producto creado: " + producto);

        req.setAttribute("saludo", serviceEjbLocal.saludar("Tucno"));
        req.setAttribute("saludo2", serviceEjb2Local.saludar("Perez"));
        req.setAttribute("listado", serviceEjbLocal.listar());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
