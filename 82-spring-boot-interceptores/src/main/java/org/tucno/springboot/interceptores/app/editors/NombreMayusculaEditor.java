package org.tucno.springboot.interceptores.app.editors;

import java.beans.PropertyEditorSupport;

// Se crea un PropertyEditor para convertir el nombre a mayúsculas
public class NombreMayusculaEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Se convierte el texto a mayúsculas y se eliminan los espacios en blanco al inicio y al final
        setValue(text.toUpperCase().trim());
    }
}
