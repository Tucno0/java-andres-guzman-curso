package org.tucno.pooclasesabstractas.tarea24;

public class Lobo extends Canino {
    private int numCamada;
    private String especieLobo;

    // Constructor

    public Lobo(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    @Override
    public String comer() {
        return "El lobo come carne en su habitat " + this.habitat + " y su especie es " + this.especieLobo;
    }

    @Override
    public String dormir() {
        return "El lobo de altura " + this.altura + " y largo " + this.largo + " está durmiendo";
    }

    @Override
    public String correr() {
        return "El lobo de la especie " + this.especieLobo + " con colmillos de tamaño " + this.tamanoColmillos + " está corriendo";
    }

    @Override
    public String comunicarse() {
        return "El lobo de nombre científico " + this.nombreCientifico + " está aullando con una camada de " + this.numCamada + " lobos";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNúmero de camada: " + numCamada +
                "\nEspecie de lobo: " + especieLobo;
    }
}
