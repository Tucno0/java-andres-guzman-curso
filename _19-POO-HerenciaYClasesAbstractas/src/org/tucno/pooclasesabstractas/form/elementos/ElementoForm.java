package org.tucno.pooclasesabstractas.form.elementos;

import org.tucno.pooclasesabstractas.form.validador.LargoValidador;
import org.tucno.pooclasesabstractas.form.validador.Validador;
import org.tucno.pooclasesabstractas.form.validador.mensaje.MensajeFormateable;

import java.util.ArrayList;
import java.util.List;

abstract public class ElementoForm { // abstract: no se puede instanciar
    // Atributos protegidos
    protected String valor; // protected: para que las clases hijas puedan acceder a este atributo sin necesidad de getters y setters
    protected String nombre;
    private List<Validador> validadores;
    private List<String> errores;

    // Constructor
    public ElementoForm() {
        this.validadores = new ArrayList<>();
        this.errores = new ArrayList<>();
    }

    public ElementoForm(String nombre) {
        this();
        this.nombre = nombre;
    }

    // Getters y setters
    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getErrores() {
        return errores;
    }

    // Métodos
    public ElementoForm addValidador(Validador validador) {
        this.validadores.add(validador);
        return this;
    }

    public boolean esValido() {
        for (Validador v: this.validadores) {
            if (!v.esValido(this.valor)) {
                if (v instanceof MensajeFormateable) {
                    this.errores.add(((MensajeFormateable) v).getMensajeFormateado(this.nombre));
                } else {
                this.errores.add(String.format(v.getMensaje(), this.nombre));
                }
            }
        }
        return this.errores.isEmpty();
    }

    // Métodos abstractos
    abstract public String dibujarHtml();
}
