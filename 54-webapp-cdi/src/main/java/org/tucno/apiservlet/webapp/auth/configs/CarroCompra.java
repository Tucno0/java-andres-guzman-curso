package org.tucno.apiservlet.webapp.auth.configs;

import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @SessionScoped: Anotación que indica que la instancia de la clase es un bean de sesión.
@SessionScoped
// @Stereotype: Anotación que indica que la anotación es un estereotipo.
@Stereotype
// @Retention: Anotación que indica que la anotación es retenida en tiempo de ejecución.
// Esto significa que la anotación estará disponible en tiempo de ejecución a través de reflexión.
@Retention(RetentionPolicy.RUNTIME)
// @Target: Anotación que indica que la anotación puede ser aplicada a tipos.
// En este caso, la anotación puede ser aplicada a clases, interfaces, enumeraciones y anotaciones.
@Target(ElementType.TYPE)
// @Named: Anotación que indica que la instancia de la clase es un bean de CDI.
@Named
public @interface CarroCompra {
}
