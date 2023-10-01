package org.tucno.pooclasesabstractas.tarea24;

public class Perro extends Canino{
    private int fuerzaMordida;

    // Constructor

    public Perro(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanoColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El perro come carne en su habitat " + this.habitat + " y su fuerza de mordida es " + this.fuerzaMordida;
    }

    @Override
    public String dormir() {
        return "El perro de altura " + this.altura + ", largo " + this.largo + " y peso " + this.peso + " está durmiendo";
    }

    @Override
    public String correr() {
        return "El perro de nombre científico " + this.nombreCientifico + " con colmillos de tamaño " + this.tamanoColmillos + " está corriendo";
    }

    @Override
    public String comunicarse() {
        return "El perro de nombre científico " + this.nombreCientifico + " está ladrando";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFuerza de mordida: " + fuerzaMordida;
    }
}
