package org.tucno.webapp.jaxws;


import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

    @PersistenceContext(name = "ejemploJpa")
    private EntityManager entityManager;

    // se anota con @Produces para que CDI pueda inyectar el EntityManager en los beans de la aplicación
    @Produces
    // se anota con @RequestScoped para que el EntityManager se cree y se destruya en cada petición HTTP
    @RequestScoped
    // se crea un método que devuelve el EntityManager para que pueda ser inyectado en los beans de la aplicación
    private EntityManager beanEntityManager() {
        return entityManager;
    }
}
