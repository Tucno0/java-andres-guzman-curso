package org.tucno.webapp.jsf3;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {
    // La anonotación @PersistenceContext se utiliza para inyectar un EntityManager en un bean de CDI.
    @PersistenceContext(unitName = "ejemploJpa")
    private EntityManager entityManager;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return entityManager;
    }
}
