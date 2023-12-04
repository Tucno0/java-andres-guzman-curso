package org.tucno.patrones.decorator.decorador;

import org.tucno.patrones.decorator.Formateable;

public class MayusculaDecorador extends TextoDecorador {

    public MayusculaDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().toUpperCase(); // Convierte el texto a mayúsculas
    }
}
