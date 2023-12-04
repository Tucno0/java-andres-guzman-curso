package org.tucno.patrones.composite.ejemplo;

import org.tucno.patrones.composite.Archivo;
import org.tucno.patrones.composite.Directorio;

public class _05_EjemploComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos"); // raíz del árbol
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patrones.pdf"));

        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream.pdf"));

        java.addComponente(stream);
        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.pdf"));
        doc.addComponente(new Archivo("foto.jpg"));

        System.out.println(doc.mostrar(0));
    }
}
