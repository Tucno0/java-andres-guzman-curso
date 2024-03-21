package org.tucno.jdbc_pool.repositories;

import org.tucno.jdbc_pool.models.Categoria;
import org.tucno.jdbc_pool.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
    private Connection conexion;

    public ProductoRepositorioImpl() {}

    public ProductoRepositorioImpl(Connection conexion) {
        this.conexion = conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (
            // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
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
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;

        // PreparedStatement es una clase de java.sql que permite ejecutar consultas parametrizadas (con ?)
        try (
            // Como esta dentro de un try-with-resources, se cierra automáticamente al terminar el bloque
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
        }

        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;

        // Si el id del producto es nulo o es igual a cero, entonces se actualiza el registro
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ?, sku = ? WHERE id = ?";

        // Si el id del producto es diferente de nulo y es mayor a cero, entonces se inserta un nuevo registro
        } else {
            sql = "INSERT INTO productos (nombre, precio, categoria_id, sku, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }

        try (
            // prepareStatement(<sql>, <flags>) es una forma segura de ejecutar consultas parametrizadas
            // Statement.RETURN_GENERATED_KEYS es un flag que indica que se desea obtener las llaves generadas por la base de datos
            // en este caso, el id del producto
            PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            stmt.setString(1, producto.getNombre());
            stmt.setDouble(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());

            // Si el id del producto es diferente de nulo y es mayor a cero, entonces se asigna el valor del id
            if (producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());

            // Si el id del producto es nulo o es igual a cero, entonces se asigna la fecha de registro
            } else {
                stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }

            stmt.executeUpdate();

            // Si el id del producto es nulo o es igual a cero, entonces se obtiene el id generado por la base de datos
            if (producto.getId() == null) {
                try ( ResultSet resultado = stmt.getGeneratedKeys() ) {
                    if (resultado.next()) {
                        producto.setId(resultado.getLong(1));
                    }
                }
            }

            return producto;
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (
            PreparedStatement stmt = conexion.prepareStatement("DELETE FROM productos WHERE id = ?")
        ) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet resultado) throws SQLException {
        Producto producto = new Producto();

        // Se asigna el valor de cada columna del registro a cada atributo del objeto Producto
        producto.setId(resultado.getLong("id"));
        producto.setNombre(resultado.getString("nombre"));
        producto.setPrecio(resultado.getDouble("precio"));
        producto.setFechaRegistro(resultado.getDate("fecha_registro"));
        producto.setSku(resultado.getString("sku"));

        Categoria categoria = new Categoria();
        categoria.setId(resultado.getLong("categoria_id"));
        categoria.setNombre(resultado.getString("categoria"));

        producto.setCategoria(categoria);

        return producto;
    }
}
