package org.tucno.jdbc_pool.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBaseDeDatos {
    // 1. Cargar el driver de la base de datos con DriverManager (DriverManager es una clase de java.sql)
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static String username = "root";
    private static String password = "70205787";
    private static BasicDataSource pool;

    public static BasicDataSource getInstance() {
        // Si la conexión es nula o está cerrada, entonces se crea una nueva conexión
        if (pool == null ) {
            pool = new BasicDataSource(); // Se crea un nuevo pool de conexiones

            pool.setUrl(url); // Establecer la URL de la base de datos
            pool.setUsername(username); // Establecer el usuario de la base de datos
            pool.setPassword(password); // Establecer la contraseña de la base de datos

            pool.setInitialSize(3); // Establecer el tamaño inicial del pool de conexiones
            pool.setMinIdle(3); // Establecer el tamaño mínimo del pool de conexiones
            pool.setMaxIdle(8); // Establecer el tamaño máximo del pool de conexiones
            pool.setMaxTotal(8); // Establecer el tamaño máximo total del pool de conexiones
        }

        // una sola instancia de conexión a la base de datos (Singleton) en toda la aplicación
        return pool;
    }

    public static Connection getConnection() throws SQLException {
        // Obtener la conexión a la base de datos (Singleton)
        return getInstance().getConnection();
    }
}
