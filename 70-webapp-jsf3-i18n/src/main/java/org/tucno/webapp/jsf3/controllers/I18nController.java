package org.tucno.webapp.jsf3.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Named
@SessionScoped
// La interfaz Serializable es necesaria para que el bean pueda ser almacenado en la sesión.
public class I18nController implements Serializable {
    private static final long serialVersionUID = 1L;

    private Locale locale;
    private String lenguaje;
    private Map<String, String> lenguajesSoportados;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
        lenguajesSoportados = new HashMap<>();
        lenguajesSoportados.put("English", "en");
        lenguajesSoportados.put("Español", "es");
    }

    // Método que se ejecuta cuando se selecciona un nuevo lenguaje en la vista.
    // El método recibe un objeto ValueChangeEvent que contiene el nuevo valor seleccionado.
    public void selecccionarLenguaje( ValueChangeEvent e ) {
        String nuevoLenguaje = e.getNewValue().toString();

        lenguajesSoportados.values().forEach( l -> {
            if (l.equals(nuevoLenguaje)) {
                this.locale = new Locale(nuevoLenguaje);
                FacesContext.getCurrentInstance().getViewRoot().setLocale(this.locale);
            }
        });
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public Map<String, String> getLenguajesSoportados() {
        return lenguajesSoportados;
    }

    public void setLenguajesSoportados(Map<String, String> lenguajesSoportados) {
        this.lenguajesSoportados = lenguajesSoportados;
    }
}
