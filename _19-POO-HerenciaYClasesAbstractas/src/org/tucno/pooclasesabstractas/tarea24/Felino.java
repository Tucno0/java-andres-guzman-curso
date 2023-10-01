package org.tucno.pooclasesabstractas.tarea24;

abstract public class Felino extends Mamifero{
    protected float tamanoGarras;
    protected Integer velocidad;

    // Constructor
    public Felino(String habitat, float altura, float largo, float peso, String nombreCientifico, float tamanoGarras, Integer velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamanoGarras = tamanoGarras;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTamaño de garras: " + tamanoGarras +
                "\nVelocidad: " + velocidad;
    }
}
