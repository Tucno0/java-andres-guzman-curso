package org.tucno.pooclasesabstractas.form.validador;

abstract public class Validador {
    // ATRIBUTOS PROTEGIDOS
    protected String mensaje;

    // MÉTODOS ABSTRACTOS
    abstract public void setMensaje(String mensaje);
    abstract public String getMensaje();
    abstract public boolean esValido(String valor);
}
