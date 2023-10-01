package org.tucno.pooclasesabstractas.tarea24;

public class Main {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[5];

        mamiferos[0] = new Tigre("Selva", 1.2f, 2.5f, 200f, "Panthera tigris", 0.5f, 80, "Naranja");
        mamiferos[1] = new Leon("Sabana", 1.3f, 2.3f, 210f, "Panthera leo", 0.5f, 80, 12, 0.5f);
        mamiferos[2] = new Guepardo("Sabana", 1.6f, 2.1f, 180f, "Acinonyx jubatus", 0.5f, 80);
        mamiferos[3] = new Lobo("Bosque", 1.2f, 2.5f, 35f, "Canis lupus", "Gris", 0.5f, 10, "Montaña");
        mamiferos[4] = new Perro("Casa", 0.5f, 3f, 15f, "Cannis", "Marron", 5f, 5);

        for (Mamifero mamifero : mamiferos) {
            System.out.println(mamifero);
            System.out.println(mamifero.comer());
            System.out.println(mamifero.dormir());
            System.out.println(mamifero.correr());
            System.out.println(mamifero.comunicarse());
            System.out.println();
        }
    }
}
