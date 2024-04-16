package org.tucno.apiservlet.webapp.auth.services;

import org.tucno.apiservlet.webapp.auth.models.Categoria;
import org.tucno.apiservlet.webapp.auth.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
            new Producto(1L, "Laptop", new Categoria("Electrónica"), 1500.0),
            new Producto(2L, "Mouse", new Categoria("Electrónica"), 20.0),
            new Producto(3L, "Teclado", new Categoria("Electrónica"), 30.0),
            new Producto(4L, "Monitor", new Categoria("Electrónica"), 300.0),
            new Producto(5L, "Impresora", new Categoria("Electrónica"), 200.0),
            new Producto(6L, "Disco Duro", new Categoria("Electrónica"), 100.0),
            new Producto(7L, "Memoria RAM", new Categoria("Electrónica"), 80.0),
            new Producto(8L, "Procesador", new Categoria("Electrónica"), 200.0),
            new Producto(9L, "Tarjeta de Video", new Categoria("Electrónica"), 150.0),
            new Producto(10L, "SSD", new Categoria("Electrónica"), 50.0),
            new Producto(11L, "Smartphone", new Categoria("Electrónica"), 500.0),
            new Producto(12L, "Tablet", new Categoria("Electrónica"), 300.0),
            new Producto(13L, "Smartwatch", new Categoria("Electrónica"), 100.0),
            new Producto(14L, "Audífonos", new Categoria("Electrónica"), 50.0),
            new Producto(15L, "Mesa", new Categoria("Muebles"), 100.0),
            new Producto(16L, "Silla", new Categoria("Muebles"), 50.0),
            new Producto(17L, "Sofá", new Categoria("Muebles"), 200.0),
            new Producto(18L, "Cama", new Categoria("Muebles"), 150.0),
            new Producto(19L, "Mesa de Centro", new Categoria("Muebles"), 80.0),
            new Producto(20L, "Comedor", new Categoria("Muebles"), 300.0)
        );
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        // Simulamos una consulta a una base de datos
        // Buscar un producto por id con el método stream() y filter()
        return listar().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategorias() {
        return List.of();
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void guardarCategoria(Categoria categoria) {

    }

    @Override
    public void eliminarCategoria(Long id) {

    }
}
