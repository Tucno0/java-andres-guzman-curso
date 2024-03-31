package org.tucno.java.tarea.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static String username = "root";
    private static String password = "70205787";
    private static Connection connection;

    public static Connection getInstance() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
