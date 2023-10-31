package org.tucno.hilos.ejemplos.runnable;

import org.tucno.hilos.ejemplos._05_SincronizacionThread;

public class ImprimirClases implements Runnable{
    private String frase1;
    private String frase2;

    public ImprimirClases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }
    @Override
    public void run() {
        _05_SincronizacionThread.imprimirFrases(frase1, frase2);
    }
}
