package org.tucno.springboot.interceptores.app.editors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tucno.springboot.interceptores.app.services.PaisService;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {
    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(idString);
            setValue(paisService.obtenerPorId(id));
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
}
