package org.tucno.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.tucno.webapp.jsf3.entities.Categoria;
import org.tucno.webapp.jsf3.entities.Producto;
import org.tucno.webapp.jsf3.services.ProductoService;

import java.util.List;

//@Named
//@RequestScoped
@Model // Este es un estereotipo que combina @Named y @RequestScoped
public class ProductoController {
    @Inject
    private ProductoService productoService;

    @Inject
    @Named("fc")
    private FacesContext facesContext;

    // Produces es una anotación que se utiliza para crear un objeto que se inyectará en otros objetos de la aplicación
    @Produces
    @Model
    public String titulo() {
        return "Hola mundo JavaServer Faces 3.0";
    }

    private Producto producto;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll() {
        return productoService.listar();
    }

    @Produces
    @Model
    public Producto producto() {
        this.producto = new Producto();
        if (id != null && id > 0) {
            productoService.porId(id).ifPresent(p -> this.producto = p);
        }

        return this.producto;
    }

    @Produces
    @Model
    public List<Categoria> categorias() {
        return productoService.listarCategorias();
    }

    public String guardar() {
        productoService.guardar(producto);
        if (producto.getId() != null && producto.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage("Producto " + producto.getNombre() + " actualizado con éxito"));
        } else {
            facesContext.addMessage(null, new FacesMessage("Producto " + producto.getNombre() + " creado con éxito"));
        }
        return "index?faces-redirect=true"; // Redirige a la página index
    }

    public String eliminar(Producto producto) {
        productoService.eliminar(producto.getId());
        facesContext.addMessage(null, new FacesMessage("Producto " + producto.getNombre() + " eliminado con éxito"));
        return "index?faces-redirect=true"; // Redirige a la página index
    }

    public String editar(Long id) {
        this.id = id;
        System.out.println("Editar producto con id: " + id);
        return "form.xhtml"; // Redirige a la página form.xhtml
    }

}
