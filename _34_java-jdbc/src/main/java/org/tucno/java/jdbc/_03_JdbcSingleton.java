package org.tucno.java.jdbc;

import org.tucno.java.jdbc.util.ConeccionBaseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _03_JdbcSingleton {
    public static void main(String[] args) {
        try (
                Connection connection = ConeccionBaseDeDatos.getInstance();
                Statement stmt = connection.createStatement();
                ResultSet resultado = stmt.executeQuery("SELECT * FROM productos");
        ){
            System.out.println("Conexión exitosa...\n");

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
