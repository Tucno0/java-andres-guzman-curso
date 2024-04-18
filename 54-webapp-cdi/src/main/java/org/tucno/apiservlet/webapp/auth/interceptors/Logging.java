package org.tucno.apiservlet.webapp.auth.interceptors;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @InterceptorBinding: Anotación que indica que la anotación es un enlace de interceptor.
// se utiliza para crear una anotación de enlace de interceptor personalizada.
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE})
public @interface Logging {
}
