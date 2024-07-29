package org.tucno.springboot.interceptores.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // Si la petición es de tipo POST, no se ejecuta el método preHandle()
        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }

        // Si el handler es una instancia de HandlerMethod, se obtiene el método del controlador
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            logger.info("Es un método del controlador: " + method.getMethod().getName());
        }

        logger.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");
        logger.info("Interceptando: " + handler);

        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        // Simulamos un tiempo de espera de la petición de 0 a 500 milisegundos
        Thread.sleep(demora);

        return true;

//        // Si el usuario no ha iniciado sesión, se redirige al formulario de login
//        response.sendRedirect(request.getContextPath().concat("/login"));
//        // Si se retorna false, no se ejecuta el método postHandle()
//        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Si la petición es de tipo POST, no se ejecuta el método preHandle()
        if (request.getMethod().equalsIgnoreCase("post")) {
            return;
        }

        long tiempoFin = System.currentTimeMillis();
        long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        // Esta validación es importante para que no se agregue el atributo si no se ha ejecutado el método preHandle()
        if (handler instanceof HandlerMethod && modelAndView != null) {
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        logger.info("Tiempo transcurrido: " + tiempoTranscurrido + " milisegundos");
        logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");
    }
}
