package org.tucno.jdbc.repository;


import org.tucno.jdbc.models.Categoria;
import org.tucno.jdbc.models.Producto;
import org.tucno.jdbc.util.ConeccionBaseDeDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorio implements Repositorio<Producto> {
    private Connection getConnection() throws SQLException {
        // Obtener la conexión a la base de datos (Singleton)
        return ConeccionBaseDeDatos.getConnection();
    }

    @Override
    public List listar() {
        List<Producto> productos = new ArrayList<>();

        try (
            Connection conexion = getConnection(); // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos AS p INNER JOIN categorias AS c ON p.categoria_id = c.id")
        ) {
            while (resultado.next()) {
                // Mapear el resultado de la consulta a un objeto Producto

                // Se crea un objeto Producto por cada registro de la tabla productos
                Producto producto = crearProducto(resultado);

                // Se agrega el objeto Producto a la lista de productos
                productos.add(producto);
            }

            return productos;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }


    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        // PreparedStatement es una clase de java.sql que permite ejecutar consultas parametrizadas (con ?)
        try (
            Connection conexion = getConnection(); // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
            PreparedStatement stmt = conexion
                .prepareStatement(
                    "SELECT p.*, c.nombre as categoria " +
                    "FROM productos AS p INNER JOIN categorias AS c ON p.categoria_id = c.id " +
                    "WHERE p.id = ?"
                )
        ) {
            // Se asigna el valor del parámetro de la consulta
            stmt.setLong(1, id);
            // Se ejecuta la consulta
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                // Se crea un objeto Producto que fue encontrado en la base de datos
                producto = crearProducto(resultado);
            }

            resultado.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;

        // Si el id del producto es nulo o es igual a cero, entonces se actualiza el registro
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";

        // Si el id del producto es diferente de nulo y es mayor a cero, entonces se inserta un nuevo registro
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, fecha_registro) VALUES (?, ?, ?, ?)";
        }

        try (
            Connection conexion = getConnection(); // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
            PreparedStatement stmt = conexion.prepareStatement(sql)
        ) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());

            // Si el id del producto es diferente de nulo y es mayor a cero, entonces se asigna el valor del id
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());

            // Si el id del producto es nulo o es igual a cero, entonces se asigna la fecha de registro
            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try (
            Connection conexion = getConnection(); // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM productos WHERE id = ?")
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Producto crearProducto(ResultSet resultado) throws SQLException {
        Producto producto = new Producto();

        // Se asigna el valor de cada columna del registro a cada atributo del objeto Producto
        producto.setId(resultado.getLong("id"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setFechaRegistro(resultado.getDate("fecha_registro"));

        Categoria categoria = new Categoria();
        categoria.setId(resultado.getLong("categoria_id"));
        categoria.setNombre(resultado.getString("categoria"));

        producto.setCategoria(categoria);

        return producto;
    }
}
