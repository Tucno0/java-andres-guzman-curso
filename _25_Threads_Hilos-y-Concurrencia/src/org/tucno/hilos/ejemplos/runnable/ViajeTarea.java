package org.tucno.hilos.ejemplos.runnable;
// Runnable es una interfaz funcional, es decir, solo tiene un método abstracto (run)
// y se puede usar como una expresión lambda o como una referencia a un método
// Es una forma de crear hilos sin tener que extender de Thread y sin tener que sobreescribir el método run
public class ViajeTarea implements Runnable {
    private String nombre;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        System.out.println( nombre + " ha comenzado");
        for (int i = 0; i < 10; i++) {
            System.out.println( i + " " + nombre);
            try {
                // Pause 10 miliseconds
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalmente viajo a: " + nombre);
    }
}
