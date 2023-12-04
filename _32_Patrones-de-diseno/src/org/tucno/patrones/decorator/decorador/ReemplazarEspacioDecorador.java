package org.tucno.patrones.decorator.decorador;

import org.tucno.patrones.decorator.Formateable;

public class ReemplazarEspacioDecorador extends TextoDecorador{

    public ReemplazarEspacioDecorador(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {
        return texto.darFormato().replace(" ", "_"); // Reemplaza los espacios por guiones bajos
    }
}
