package org.tucno.pooclasesabstractas.form.elementos;

import org.tucno.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{
    // ATRIBUTOS
    private List<Opcion> opciones;

    // CONSTRUCTORES
    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>();
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    // GETTERS Y SETTERS


    // MÉTODOS
    public SelectForm addOpcion(Opcion opcion) {
        this.opciones.add(opcion);
        return this;
    }

    // SOBRE-ESCRITURA DE MÉTODOS DE LA CLASE PADRE
    @Override
    public String dibujarHtml() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name=\"").append(this.nombre).append("\">\n");

        for (Opcion opcion : this.opciones) {
            sb.append("\t<option value=\"").append(opcion.getValor()).append("\"");
            if (opcion.isSelected()) {
                sb.append(" selected");
                this.valor = opcion.getValor();
            }

            sb.append(">").append(opcion.getNombre()).append("</option>\n");
        }

        sb.append("</select>");
        return sb.toString();
    }
}
