package org.tucno.webpp.ejb.services;

import jakarta.ejb.Stateful;
import jakarta.enterprise.context.RequestScoped;
import org.tucno.webpp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Stateless: Crea una instancia por cada llamada al EJB
 * Stateful: Crea una instancia por cada cliente que se conecta al EJB
 * Singleton: Crea una instancia por cada aplicación
 * RequestScoped: Crea una instancia por cada petición HTTP
 */

@RequestScoped
@Stateful
public class ServiceEjb implements ServiceEjbLocal {
    private int contador;

    public String saludar(String nombre) {
        System.out.println("imprimiendo en consola desde el EJB con instancia: " + this);
        contador++;
        System.out.println("Contador: " + contador);
        return "Hola que tal " + nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto 1"));
        productos.add(new Producto("Producto 2"));
        productos.add(new Producto("Producto 3"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Creando producto: " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
