package org.tucno.java.jdbc;

import java.sql.*;

public class _01_EjemploJdbc {
    public static void main(String[] args) {
        // JAVA JDBC
        // JDBC: Java Database Connectivity
        // API de Java para conectarse a una base de datos relacional (RDBMS)
        // JDBC es un API, no es una implementación de un driver de conexión a una base de datos relacional
        // Nos permite conectarnos a una base de datos relacional, ejecutar sentencias SQL y obtener resultados de las consultas
        // JDBC es un API que se encuentra en el paquete java.sql y javax.sql

        // Connection: representa la conexión a la base de datos relacional
        // Statement: representa una sentencia SQL que se ejecutará en la base de datos
        // ResultSet: representa el resultado de una consulta a la base de datos

        // 1. Cargar el driver de la base de datos con DriverManager (DriverManager es una clase de java.sql)
        String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Lima";
        String username = "root";
        String password = "70205787";

        // Cuando ponemos el código dentro de un bloque try-with-resources, no es necesario cerrar la conexión a la base de datos
        // La conexión se cerrará automáticamente al finalizar el bloque try-with-resources (al finalizar el bloque try)

        try (
                Connection conn = DriverManager.getConnection(url, username, password);

                // 2. Obtener la conexión a la base de datos
                // System.out.println("Conexión exitosa...\n");

                // 3. Crear un objeto Statement
                Statement stmt = conn.createStatement();

                // 4. Ejecutar la sentencia SQL y obtener el resultado con ResultSet
                ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")
        ) {
            System.out.println("Conexión exitosa...\n");

            // 5. Obtener el resultado de la consulta
            while (resultado.next()) {
                System.out.print(resultado.getInt("id") + " ");
                System.out.print(" | ");
                System.out.print(resultado.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultado.getDouble("precio"));
                System.out.print(" | ");
                System.out.println(resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
