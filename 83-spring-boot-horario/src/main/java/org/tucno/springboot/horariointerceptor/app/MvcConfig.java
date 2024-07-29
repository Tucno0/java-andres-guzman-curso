package org.tucno.springboot.horariointerceptor.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration permite que Spring sepa que esta clase es una clase de configuración
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier("horario")
    private HandlerInterceptor horarioInterceptor;

    // Se registra el interceptor
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Se excluye la ruta /cerrado para que no se aplique el interceptor
        registry.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
    }
}
