package org.tucno.java.jdbc_close.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConeccionBaseDeDatos {
    // 1. Cargar el driver de la base de datos con DriverManager (DriverManager es una clase de java.sql)
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static String username = "root";
    private static String password = "70205787";
    private static Connection connection;

    public static Connection getInstance() {
        try {
            // Si la conexión es nula o está cerrada, entonces se crea una nueva conexión
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }

        // una sola instancia de conexión a la base de datos (Singleton) en toda la aplicación
        return connection;
    }
}
