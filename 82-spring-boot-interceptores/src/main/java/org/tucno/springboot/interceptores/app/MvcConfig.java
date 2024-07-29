package org.tucno.springboot.interceptores.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration es una anotación de Spring que indica que esta clase es una clase de configuración.
// Esto significa que la clase podría contener métodos anotados con @Bean que devuelven objetos que deben registrarse en el contexto de Spring.
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier("tiempoTranscurridoInterceptor") // Se utiliza para inyectar el interceptor por nombre
    private HandlerInterceptor tiempoTranscurridoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Se agrega el interceptor al registro de interceptores
        // addPathPatterns se utiliza para agregar las rutas que se van a interceptar con el interceptor
        registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");

        // Si no se agrega ninguna ruta, el interceptor se ejecutará en todas las rutas
//        registry.addInterceptor(tiempoTranscurridoInterceptor);
    }
}
