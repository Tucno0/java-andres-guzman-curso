package org.tucno.apiservlet.webapp.jpa.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    // EntityManagerFactory es una interfaz de JPA que se encarga de crear instancias de EntityManager (gestor de entidades)
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // Se crea una única instancia de EntityManagerFactory para toda la aplicación
    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("webapp-jpa");
    }

    // Método que devuelve una instancia de EntityManager, siempre devuelve una nueva instancia
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
