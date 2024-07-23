package org.tucno.webpp.ejb.jaas.services;

import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateful;
import org.tucno.webpp.ejb.jaas.models.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * Stateless: Crea una instancia por cada llamada al EJB
 * Stateful: Crea una instancia por cada cliente que se conecta al EJB
 * Singleton: Crea una instancia por cada aplicación
 */

//@Stateless
@Stateful
@DeclareRoles({"ADMIN", "USER"})
public class ServiceEjb implements ServiceEjbRemote {
    private int contador;

    @RolesAllowed({"ADMIN", "USER"})
    public String saludar(String nombre) {
        System.out.println("imprimiendo en consola desde el EJB con instancia: " + this);
        contador++;
        System.out.println("Contador: " + contador);
        return "Hola que tal " + nombre;
    }

    @Override
    @RolesAllowed({"ADMIN", "USER"})
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto 1"));
        productos.add(new Producto("Producto 2"));
        productos.add(new Producto("Producto 3"));
        return productos;
    }

    @Override
    @RolesAllowed({"ADMIN"})
    public Producto crear(Producto producto) {
        System.out.println("Creando producto: " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
