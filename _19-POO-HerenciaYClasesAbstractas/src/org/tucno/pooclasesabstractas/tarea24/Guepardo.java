package org.tucno.pooclasesabstractas.tarea24;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, Integer velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
    }

    // Métodos que si o si deben ser implementados por la clase abstracta
    @Override
    public String comer() {
        return "El guepardo come carne con garras de tamaño " + this.tamanoGarras + " en su habitat " + this.habitat;
    }

    @Override
    public String dormir() {
        return "El guepardo de altura " + this.altura + ", largo " + this.largo + " y peso " + this.peso + " está durmiendo";
    }

    @Override
    public String correr() {
        return "El guepardo está corriendo a " + this.velocidad + " km/h, con garras de tamaño " + this.tamanoGarras + " en su habitat " + this.habitat;
    }

    @Override
    public String comunicarse() {
        return "El guepardo de nombre científico " + this.nombreCientifico + " está rugiendo";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
