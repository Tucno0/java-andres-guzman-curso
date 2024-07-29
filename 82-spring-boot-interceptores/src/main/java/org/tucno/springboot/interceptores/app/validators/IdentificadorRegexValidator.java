package org.tucno.springboot.interceptores.app.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator se utiliza para validar un campo con una expresión regular personalizada
// El primer parámetro es la anotación que se va a utilizar y el segundo es el tipo de dato que se va a validar
public class IdentificadorRegexValidator implements ConstraintValidator<IdentificadorRegex, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Si el valor cumple con la expresión regular, se retorna verdadero
        if (value.matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
            return true;
        }
        // Si el valor no cumple con la expresión regular, se retorna falso
        return false;
    }
}
