package org.tucno.poointerfaces.imprenta.modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible{
    private Persona persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencia(String experiencia){
        this.experiencias.add(experiencia);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Curriculum Vitae\n");
        sb.append("Nombre: ").append(this.persona).append("\n")
                .append("Resumen: ").append(this.contenido).append("\n")
                .append("Carrera: ").append(this.carrera).append("\n")
                .append("Experiencias: ").append("\n");

        for (String exp: this.experiencias) {
            sb.append("- ").append(exp).append("\n");
        }

        return sb.toString();
    }
}
