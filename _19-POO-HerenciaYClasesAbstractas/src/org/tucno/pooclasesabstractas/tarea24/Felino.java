package org.tucno.pooclasesabstractas.tarea24;

// Las clases hijas abstractas no necesitan implementar los métodos abstractos de la clase padre
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
