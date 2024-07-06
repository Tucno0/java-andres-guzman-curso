package org.tucno.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.tucno.webapp.jsf3.entities.Producto;
import org.tucno.webapp.jsf3.services.ProductoService;

import java.util.List;

//@Named
//@RequestScoped
@Model // Este es un estereotipo que combina @Named y @RequestScoped
public class ProductoController {
    @Inject
    private ProductoService productoService;

    // Produces es una anotación que se utiliza para crear un objeto que se inyectará en otros objetos de la aplicación
    @Produces
    @Model
    public String titulo() {
        return "Hola mundo JavaServer Face 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll() {
        return productoService.listar();
    }
}
