package org.tucno.springboot.form.app.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.tucno.springboot.form.app.models.domain.Usuario;

// @Component se utiliza para registrar la clase en el contenedor de Spring y poder inyectarla en otras clases
@Component
// Validator se utiliza para validar los campos de un objeto y personalizar los mensajes de error de validación en un formulario
public class UsuarioValidator implements Validator {
    @Override
    // Este método se utiliza para verificar si la clase que se está validando es la misma que la que se está validando
    public boolean supports(Class<?> clazz) {
        // isAssignableFrom se utiliza para verificar si la clase que se está validando es la misma que la que se está validando
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    // Este método se utiliza para validar los campos de un objeto y personalizar los mensajes de error de validación
    public void validate(Object target, Errors errors) {
        // Se obtiene el objeto Usuario que se está validando
//        Usuario usuario = (Usuario) target;

        // rejectIfEmpty se utiliza para validar que un campo no esté vacío y personalizar el mensaje de error
        // rejectIfEmpty(<se obtiene el objeto Errors>, <se obtiene el nombre del campo>, <se obtiene el mensaje de error>)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Required.usuario.nombre");

        // Se valida que el campo nombre no esté vacío, es lo mismo que el método anterior
//        if (usuario.getNombre().isEmpty()) {
//            // Se agrega un error al campo nombre con el mensaje "El campo nombre no puede estar vacío"
//            errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
//        }

        // Se valida que el campo apellido no esté vacío
//        if (!usuario.getCodigo().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
//            errors.rejectValue("codigo", "Pattern.usuario.codigo");
//        }
    }
}
