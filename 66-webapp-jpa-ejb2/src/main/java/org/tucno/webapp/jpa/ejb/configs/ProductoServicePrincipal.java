package org.tucno.webapp.jpa.ejb.configs;

import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier // Qualifier es una anotación que se utiliza para marcar una anotación personalizada que se utiliza para calificar un bean.
// Retention es una anotación que se utiliza para marcar otra anotación personalizada que se utiliza para especificar cuánto tiempo se debe retener una anotación.
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface ProductoServicePrincipal {
}
