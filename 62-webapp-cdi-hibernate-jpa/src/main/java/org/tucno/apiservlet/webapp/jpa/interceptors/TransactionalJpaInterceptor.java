package org.tucno.apiservlet.webapp.jpa.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;

import java.util.logging.Logger;

@TransactionalJpa
@Interceptor
public class TransactionalJpaInterceptor {
    @Inject
    private EntityManager entityManager;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext context) throws Exception {

        try {
            logger.info(STR."-------- > Iniciando transacción \{context.getMethod().getName()} de la clase \{context.getMethod().getDeclaringClass()} < --------");
            entityManager.getTransaction().begin();

            Object resultado = context.proceed();

            entityManager.getTransaction().commit();
            logger.info(STR."-------- > Realizando commit y finalizando transacción \{context.getMethod().getName()} de la clase \{context.getMethod().getDeclaringClass()} < --------");
            return resultado;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.severe(e.getMessage());
            throw e;
        }
    }
}
