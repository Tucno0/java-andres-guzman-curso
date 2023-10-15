package org.tucno.pooclasesabstractas.tarea24;

// Las clases hijas abstractas no necesitan implementar los métodos abstractos de la clase padre
abstract public class Canino extends Mamifero{
    protected String color;
    protected float tamanoColmillos;

    // Constructor
    public Canino(String habitat, float altura, float largo, float peso, String nombreCientifico, String color, float tamanoColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanoColmillos = tamanoColmillos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nColor: " + color +
                "\nTamaño de colmillos: " + tamanoColmillos;
    }
}
