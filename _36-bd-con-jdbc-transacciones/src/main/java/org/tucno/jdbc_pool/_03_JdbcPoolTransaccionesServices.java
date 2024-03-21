package org.tucno.jdbc_pool;

import org.tucno.jdbc_pool.models.Categoria;
import org.tucno.jdbc_pool.models.Producto;
import org.tucno.jdbc_pool.services.CatalogoServicio;
import org.tucno.jdbc_pool.services.Servicio;

import java.sql.SQLException;
import java.util.Date;

public class _03_JdbcPoolTransaccionesServices {
    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();

        //------------ Obtener la lista de productos ------------
        System.out.println("\nLista de productos: ");
        servicio.listarProductos().forEach(System.out::println);

        //------------ Crear una nueva categoría ------------
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");

        //------------ Crear un nuevo producto ------------
        Producto producto = new Producto();
        producto.setNombre("Lampara de escritorio");
        producto.setPrecio(990.0);
        producto.setFechaRegistro(new Date());
        producto.setSku("LAMP-001");

        servicio.guardarProductoConCategoria(producto, categoria);

        System.out.println("\nProducto guardado: " + producto.getId());

        System.out.println("\nLista de productos: ");
        servicio.listarProductos().forEach(System.out::println);
    }
}
