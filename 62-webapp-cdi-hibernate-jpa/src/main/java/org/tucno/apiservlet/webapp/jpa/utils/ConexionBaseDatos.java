package org.tucno.apiservlet.webapp.jpa.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
    private static final String username = "root";
    private static final String password = "70205787";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, username, password);
    }
}
