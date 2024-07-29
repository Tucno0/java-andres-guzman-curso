package org.tucno.springboot.interceptores.app.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tucno.springboot.interceptores.app.services.RoleService;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {
    @Autowired
    private RoleService roleService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(text);
            // Se asigna el valor al campo que se está editando en el formulario
            setValue(roleService.obtenerPorId(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
}
