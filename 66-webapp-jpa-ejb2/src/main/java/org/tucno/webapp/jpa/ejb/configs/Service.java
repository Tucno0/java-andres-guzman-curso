package org.tucno.webapp.jpa.ejb.configs;

import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;
import org.tucno.webapp.jpa.ejb.interceptors.Logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Logging // @Logging: Anotación de enlace de interceptor personalizada. Es para todos los métodos de la clase
@Stereotype
@Named
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
}
