package org.tucno.webapp.jsf3;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

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
}
