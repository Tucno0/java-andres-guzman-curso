package org.tucno.springboot.interceptores.app.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// @Constraint se utiliza para indicar que la anotación es una anotación de validación personalizada
@Constraint(validatedBy = RequeridoValidator.class)
// @Retention se utiliza para indicar que la anotación estará disponible en tiempo de ejecución (RUNTIME)
@Retention(RetentionPolicy.RUNTIME)
// @Target se utiliza para indicar en qué elementos se puede utilizar la anotación (FIELD, METHOD)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface Requerido {
    String message() default "El campo es requerido - usando anotaciones";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
