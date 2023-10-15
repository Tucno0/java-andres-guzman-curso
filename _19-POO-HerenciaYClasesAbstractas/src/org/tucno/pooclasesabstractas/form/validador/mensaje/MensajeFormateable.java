package org.tucno.pooclasesabstractas.form.validador.mensaje;

// Interfaces: no se pueden instanciar, pero sí implementar
// Todos los métodos de una interfaz son abstractos y públicos
// Todos los atributos de una interfaz son públicos, estáticos y finales
public interface MensajeFormateable { // Una interfaz puede extender otra interfaz
    public String getMensajeFormateado(String campo);
}
