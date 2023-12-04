package org.tucno.patrones.observer.ejemplos;

import org.tucno.patrones.observer.Corporacion;

public class _07_EjemploObserver {
    public static void main(String[] args) {
        Corporacion google = new Corporacion("Google", 1000);

        google.addObserver((observable, object) -> {
            System.out.println("Jhon -> " + observable);
        });

        google.addObserver((observable, object) -> {
            System.out.println("Jane -> " + observable);
        });

        google.addObserver((observable, object) -> {
            System.out.println("Bob -> " + observable);
        });

        google.modificaPrecio(2000);
    }
}
