package org.tucno.pooclasesabstractas.form.elementos;

// Si la clase hija no es abstracta, debe implementar todos los métodos abstractos de la clase padre
// Si la clase hija es abstracta, no es necesario implementar los métodos abstractos de la clase padre
public class InputForm extends ElementoForm{
    // ATRIBUTOS
    private String tipo = "text";

    // CONSTRUCTORES

    public InputForm(String nombre) {
        super(nombre);
    }

    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    // GETTERS Y SETTERS

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // MÉTODOS

    @Override
    public String dibujarHtml() {
        return "<input type=\"" + this.tipo + "\" name=\"" + this.nombre + "\" value=\"" + this.valor + "\">";
    }
}
