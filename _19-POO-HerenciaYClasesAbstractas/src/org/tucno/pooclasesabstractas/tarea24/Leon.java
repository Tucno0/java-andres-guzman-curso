package org.tucno.pooclasesabstractas.tarea24;

public class Leon extends Felino{
    // Atributos
    private int numManada;
    private float potenciaRugidoDecibel;

    // Constructor

    public Leon(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, Integer velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return "El león está de caza con un grupo de " + this.numManada + " leones, con garras de tamaño " + this.tamanoGarras;
    }

    @Override
    public String dormir() {
        return "El león de altura " + this.altura + ", largo " + this.largo + " y peso " + this.peso + " está durmiendo";
    }

    @Override
    public String correr() {
        return "El león está corriendo a " + this.velocidad + " km/h, con garras de tamaño " + this.tamanoGarras;
    }

    @Override
    public String comunicarse() {
        return "El león de nombre científico " + this.nombreCientifico + " está rugiendo con una potencia de " + this.potenciaRugidoDecibel + " decibelios";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNúmero de manada: " + numManada +
                "\nPotencia de rugido: " + potenciaRugidoDecibel;
    }
}
