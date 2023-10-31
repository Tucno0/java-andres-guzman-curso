package org.tucno.hilos.ejemplos;

import org.tucno.hilos.ejemplos.runnable.ImprimirClases;

public class _05_SincronizacionThread {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ImprimirClases("Hola ", "que tal")).start();
        new Thread(new ImprimirClases("¿Quien eres", " tu?")).start();
        Thread h3 = new Thread(new ImprimirClases("Muchas ", "gracias amigo!"));

        Thread.sleep(1000);

        // Cuando comienza la ejecución del hilo h3, el estado va a ser blocked porque el mé todo imprimirFrases() es synchronized.
        h3.start();
        Thread.sleep(100);
        System.out.println("\nEstado del hilo 3: " + h3.getState());
    }

    // El método imprimirFrases() es synchronized, por lo que solo un hilo puede ejecutarlo a la vez.
    // Si no fuera synchronized, los hilos se ejecutarían a la vez y las frases se imprimirían mezcladas.
    // Cuando un hilo ejecuta el método imprimirFrases(), el resto de hilos que intenten ejecutarlo se quedan bloqueados.
    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(frase2);
    }
}
