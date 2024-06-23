package org.tucno.webapp.jpa.ejb.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

// @Dependent: Anotación que indica que la instancia de la clase es un bean de dependencia.
//@Dependent
@ApplicationScoped
public class ProducerResources {
    @Inject
    private Logger logger;

    // Resource es una anotación que se utiliza para marcar un campo o un método setter que se inyectará con un recurso.
    @Resource(lookup = "java:/MySqlDS")
    private DataSource ds;

    // PersistenceUnit es una anotación que se utiliza para marcar un campo o un método setter que se inyectará con un EntityManagerFactory.
    @PersistenceUnit(name = "ejemploJpa")
    private EntityManagerFactory emf;

    // Produces es una anotación que se utiliza para marcar un método que produce un recurso que se inyectará en un campo, un método o un constructor de un bean.
    // En este caso, se produce una conexión a la base de datos.
    @Produces
    // RequestScoped es una anotación que se utiliza para marcar un bean que tiene un ciclo de vida atado a una solicitud HTTP.
    @RequestScoped
//    @Named("connection")
    @MysqlConnection // Se utiliza la anotación personalizada MysqlConnection para calificar el bean.
    private Connection beanConnection () throws NamingException, SQLException {
//        Context initContext = null;
//        initContext = new InitialContext();
//        Context envContext  = (Context) initContext.lookup("java:/comp/env");
//        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");
        Connection connection = ds.getConnection();
        return connection;
    }

    @Produces
    private Logger beanLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }

    public void close(@Disposes @MysqlConnection Connection connection) throws SQLException {
        connection.close();
        logger.info("Cerrando conexión a la base de datos");
    }

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
            logger.info("Cerrando conexión a la base de datos");
        }
    }
}
