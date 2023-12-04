package org.tucno.patrones.decorator.decorador;

import org.tucno.patrones.decorator.Formateable;

abstract public class TextoDecorador implements Formateable {
    protected Formateable texto; // Componente a decorar

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
