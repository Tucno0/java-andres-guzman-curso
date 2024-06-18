package org.tucno.apiservlet.webapp.jpa.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import org.tucno.apiservlet.webapp.jpa.configs.MysqlConnection;

import java.sql.Connection;
import java.util.logging.Logger;

@TransactionalJdbc
@Interceptor
public class TransactionalJdbcInterceptor {
    @Inject
    @MysqlConnection
    private Connection connection;

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object transactional(InvocationContext context) throws Exception {
        if (connection.getAutoCommit()) {
            connection.setAutoCommit(false);
        }

        try {
            logger.info(STR."-------- > Iniciando transacción \{context.getMethod().getName()} de la clase \{context.getMethod().getDeclaringClass()} < --------");
            Object resultado = context.proceed();
            connection.commit();
            logger.info(STR."-------- > Realizando commit y finalizando transacción \{context.getMethod().getName()} de la clase \{context.getMethod().getDeclaringClass()} < --------");
            return resultado;
        } catch (Exception e) {
            connection.rollback();
            logger.severe(e.getMessage());
            throw e;
        }
    }
}
