package org.tucno.pooclasesabstractas.tarea24;

public class Tigre extends Felino{
    // Atributos
    private String especieTigre;

    // Constructor

    public Tigre(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, Integer velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    @Override
    public String comer() {
        return "El tigre de la especie " + this.especieTigre + " está comiendo en su habitat " + this.habitat ;
    }

    @Override
    public String dormir() {
        return "El tigre de altura " + this.altura + " y largo " + this.largo + " está durmiendo";
    }

    @Override
    public String correr() {
        return "El tigre de la especie " + this.especieTigre + " con garras de tamaño " + this.tamanoGarras + " está corriendo a " + this.velocidad + " km/h";
    }

    @Override
    public String comunicarse() {
        return "El tigre de nombre científico " + this.nombreCientifico + " está rugiendo";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nEspecie de tigre: " + especieTigre;
    }
}
