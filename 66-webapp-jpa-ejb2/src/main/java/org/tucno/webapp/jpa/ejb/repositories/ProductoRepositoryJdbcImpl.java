package org.tucno.webapp.jpa.ejb.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;
import org.tucno.webapp.jpa.ejb.configs.MysqlConnection;
import org.tucno.webapp.jpa.ejb.configs.Repository;
import org.tucno.webapp.jpa.ejb.models.entities.Categoria;
import org.tucno.webapp.jpa.ejb.models.entities.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
@RepositoryJdbc
public class ProductoRepositoryJdbcImpl implements CrudRepository<Producto> {
    @Inject
//    @Named("connection")
    @MysqlConnection
    private Connection connection;

    @Inject
    private Logger logger;

    @PostConstruct
    public void iniciar() {
        logger.info("Iniciando el beans " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destruir() {
        logger.info("Destruyendo el beans " + this.getClass().getSimpleName());
    }

    @Override
    public List listar() throws SQLDataException {
        List<Producto> productos = new ArrayList<>();

        // Statement es una clase que se utiliza para ejecutar sentencias SQL
        try(Statement statement = connection.createStatement()) {
            //language=SQL
            String query = " SELECT p.*, c.nombre as categoria FROM productos as p INNER JOIN categorias as c ON p.categoria_id = c.id ORDER BY p.id ASC";

            // ResultSet es una clase que nos permite recorrer los resultados de una consulta SQL
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Producto producto = getProducto(resultSet);
                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLDataException {
        Producto producto = null;

        try(Statement statement = connection.createStatement()) {
            //language=SQL
            String query = """
                SELECT p.*, c.nombre as categoria FROM productos as p
                INNER JOIN categorias as c ON p.categoria_id = c.id
                WHERE p.id = %d
            """.formatted(id);

            try (ResultSet resultSet = statement.executeQuery(query)) {
                // Si hay un resultado
                if (resultSet.next()) {
                    producto = getProducto(resultSet);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLDataException {
        String query;

        if (producto.getId() != null && producto.getId() > 0) {
            query = """
                UPDATE productos SET nombre = '%s', precio = %f, categoria_id = %d, sku = '%s'
                WHERE id = %d
            """.formatted(producto.getNombre(), producto.getPrecio(), producto.getCategoria().getId(), producto.getSku(), producto.getId());
        } else {
            query = """
                INSERT INTO productos (nombre, precio, categoria_id, sku, fecha_registro)
                VALUES ('%s', %f, %d, '%s', '%s')
            """.formatted(producto.getNombre(), producto.getPrecio(), producto.getCategoria().getId(), producto.getSku(), Date.valueOf(producto.getFechaRegistro()));
        }

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLDataException {
        //language=SQL
        String query = "DELETE FROM productos WHERE id = %d".formatted(id);

        try(Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto producto = new Producto();
        producto.setId(resultSet.getLong("id"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));

        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getLong("categoria_id"));
        categoria.setNombre(resultSet.getString("categoria"));
        producto.setCategoria(categoria);

        producto.setSku(resultSet.getString("sku"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro").toLocalDate());

        return producto;
    }
}
