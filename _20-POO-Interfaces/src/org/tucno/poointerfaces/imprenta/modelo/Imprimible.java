package org.tucno.poointerfaces.imprenta.modelo;

public interface Imprimible {
    // Las interfaces solo pueden tener constantes publicas y estaticas
    final static String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    // Un metodo de una interfaz no puede ser privado, debe ser publico o default
    // Cuando un metodo de una interfaz esta default no es obligatorio implementarlo en las clases que implementan la interfaz
    default String imprimir() { // Los métodos default no son obligatorios de implementar
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible) { // Los métodos estáticos no son obligatorios de implementar
        System.out.println(imprimible.imprimir());
    }
}
