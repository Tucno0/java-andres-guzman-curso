package org.tucno.poointerfaces.imprenta.modelo;

public interface Imprimible {
    final static String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    default String imprimir() { // Los métodos default no son obligatorios de implementar
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible) { // Los métodos estáticos no son obligatorios de implementar
        System.out.println(imprimible.imprimir());
    }
}
