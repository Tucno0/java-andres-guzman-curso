package org.tucno.webapp.jpa.ejb.configs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// @Dependent: Anotación que indica que la instancia de la clase es un bean de dependencia.
//@Dependent
// @ApplicationScoped: Anotación que indica que la instancia de la clase es un bean de aplicación.
// @RequestScoped: Anotación que indica que la instancia de la clase es un bean de solicitud.
@RequestScoped
// @ApplicationScoped: Anotación que indica que la instancia de la clase es un bean de aplicación.
//@ApplicationScoped
public class ProducerEntityManager {
    // PersistenceUnit es una anotación que se utiliza para marcar un campo o un método setter que se inyectará con un EntityManagerFactory.
    @PersistenceContext(name = "ejemploJpa")
    private EntityManager em;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return em;
    }
}
