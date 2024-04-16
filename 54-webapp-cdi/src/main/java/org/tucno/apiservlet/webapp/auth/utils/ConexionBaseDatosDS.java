package org.tucno.apiservlet.webapp.auth.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBaseDatosDS {

    public static Connection getConnection() throws SQLException, NamingException {
        // Context es una interfaz que representa un entorno de ejecución de Java Naming and Directory Interface (JNDI).
        // Sirve para buscar objetos en un entorno de ejecución.
        Context initContext = null;

        // Se crea un objeto de tipo InitialContext para buscar objetos en un entorno de ejecución.
        // InitialContext es una clase que implementa un contexto inicial de JNDI.
        initContext = new InitialContext();

        // Se obtiene el contexto de entorno de ejecución. El contexto de entorno de ejecución es un subconjunto del
        // contexto de JNDI que contiene referencias a objetos que son específicos de un entorno de ejecución.
        Context envContext  = (Context) initContext.lookup("java:/comp/env");

        // DataSource es una interfaz que representa una fuente de datos que se puede conectar a través de una conexión.
        // Es una interfaz que implementa un objeto que puede proporcionar conexiones a una base de datos.
        // Se obtiene el DataSource de la base de datos.
        DataSource ds = (DataSource) envContext.lookup("jdbc/mysqlDB");

        // Se obtiene una conexión a la base de datos.
        Connection connection = ds.getConnection();
        // Se retorna la conexión.
        return connection;
    }
}
