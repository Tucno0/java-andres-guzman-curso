package org.tucno.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.Locale;
import java.util.ResourceBundle;

@ApplicationScoped
public class ProducerResources {
    @Produces
    @RequestScoped
    @Named("fc") // Se le asigna un nombre al objeto para evitar conflictos con otros objetos que tengan el mismo tipo.
    // FacesContext es una clase de JSF que nos permite acceder a los objetos de JSF como el ExternalContext, ApplicationMap, RequestMap, etc.
    public FacesContext beanFacesContext() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().getFlash().setKeepMessages(true); // Se configura para que los mensajes flash se mantengan en la redirección.
        return facesContext;
    }

    @Produces
    @Named("msg")
    // ResourceBundle es una clase de Java que nos permite acceder a los archivos de propiedades.
    public ResourceBundle beanBundle() {
        // se obtiene el locale de la vista actual
        // getCurrentInstance() nos devuelve la instancia actual de FacesContext
        // getViewRoot() nos devuelve el componente raíz de la vista actual
        // getLocale() nos devuelve el locale de la vista actual
        Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

        // Se crea un ResourceBundle con el archivo de propiedades texts.properties y el locale de la vista actual.
        return ResourceBundle.getBundle("messages", locale);
    }
}
