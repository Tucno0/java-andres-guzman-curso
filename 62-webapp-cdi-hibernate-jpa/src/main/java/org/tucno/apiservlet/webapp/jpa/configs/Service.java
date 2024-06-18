package org.tucno.apiservlet.webapp.jpa.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import org.tucno.apiservlet.webapp.jpa.interceptors.Logging;
import org.tucno.apiservlet.webapp.jpa.interceptors.TransactionalJdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Logging // @Logging: Anotación de enlace de interceptor personalizada. Es para todos los métodos de la clase
@ApplicationScoped
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
