package org.tucno.apiservlet.webapp.jdbc.services;

import org.tucno.apiservlet.webapp.jdbc.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L, "Laptop", "Electrónica", 1500.0),
                new Producto(2L, "Mouse", "Electrónica", 20.0),
                new Producto(3L, "Teclado", "Electrónica", 30.0),
                new Producto(4L, "Monitor", "Electrónica", 300.0),
                new Producto(5L, "Impresora", "Electrónica", 200.0),
                new Producto(6L, "Disco Duro", "Electrónica", 100.0),
                new Producto(7L, "Memoria RAM", "Electrónica", 80.0),
                new Producto(8L, "Procesador", "Electrónica", 200.0),
                new Producto(9L, "Tarjeta de Video", "Electrónica", 150.0),
                new Producto(10L, "SSD", "Electrónica", 50.0),
                new Producto(11L, "Smartphone", "Electrónica", 500.0),
                new Producto(12L, "Tablet", "Electrónica", 300.0),
                new Producto(13L, "Smartwatch", "Electrónica", 100.0),
                new Producto(14L, "Audífonos", "Electrónica", 50.0),
                new Producto(15L, "Mesa", "Muebles", 100.0),
                new Producto(16L, "Silla", "Muebles", 50.0),
                new Producto(17L, "Sofá", "Muebles", 200.0),
                new Producto(18L, "Cama", "Muebles", 150.0),
                new Producto(19L, "Mesa de Centro", "Muebles", 80.0),
                new Producto(20L, "Comedor", "Muebles", 300.0)
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
}
