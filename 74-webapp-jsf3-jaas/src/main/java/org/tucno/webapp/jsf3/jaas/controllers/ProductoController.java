package org.tucno.webapp.jsf3.jaas.controllers;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.tucno.webapp.jsf3.jaas.entities.Categoria;
import org.tucno.webapp.jsf3.jaas.entities.Producto;
import org.tucno.webapp.jsf3.jaas.services.ProductoService;

import java.util.List;
import java.util.ResourceBundle;

//@Named
//@RequestScoped
@Model // Este es un estereotipo que combina @Named y @RequestScoped
public class ProductoController {
    @Inject
    private ProductoService productoService;

    @Inject
    @Named("fc")
    private FacesContext facesContext;

    @Inject
    private ResourceBundle bundle;

    private Producto producto;
    private Long id;
    private List<Producto> listado;
    private String textoBuscar;

    // PostConstruct es una anotación que se utiliza para ejecutar un método después de que el bean haya sido creado.
    @PostConstruct
    public void init() { // Por cada request se ejecuta este método
        listado = productoService.listar();
        producto = new Producto();
    }

    // Los getters y setters son métodos que permiten obtener y establecer los valores de los atributos de una clase
    // Son necesarios para que JSF pueda acceder a los atributos de la clase
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getListado() {
        return listado;
    }

    public void setListado(List<Producto> listado) {
        this.listado = listado;
    }

    public String getTextoBuscar() {
        return textoBuscar;
    }

    public void setTextoBuscar(String textoBuscar) {
        this.textoBuscar = textoBuscar;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    //    @Produces
//    @RequestScoped
//    @Named("listado")
//    public List<Producto> findAll() {
//        return productoService.listar();
//    }

    // Produces es una anotación que se utiliza para crear un objeto que se inyectará en otros objetos de la aplicación
    @Produces
    @Model
    public String titulo() {
//        return "Hola mundo JavaServer Faces 3.0";
        return bundle.getString("producto.texto.titulo");
    }

//    @Produces
//    @Model
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

    public void guardar() {
        if (producto.getId() != null && producto.getId() > 0) {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.editar"), producto.getNombre())));
        } else {
            facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.crear"), producto.getNombre())));
        }

        productoService.guardar(producto);
        listado = productoService.listar();
        producto = new Producto();
        this.id = null;
//        return "index.xhtml"; // Redirige a la página index
    }

    public void eliminar(Producto producto) {
        productoService.eliminar(producto.getId());
        facesContext.addMessage(null, new FacesMessage(String.format(bundle.getString("producto.mensaje.eliminar"), producto.getNombre())));
        listado = productoService.listar();
    }

    public void buscar() {
        this.listado = productoService.buscarPorNombre(this.textoBuscar);
    }

    public void editar(Long id) {
        this.id = id;
        producto();
        System.out.println("Editar producto con id: " + id);
//        return "form.xhtml"; // Redirige a la página form.xhtml
    }

    public void closeDialog() {
        System.out.println("Cerrando la ventana modal");
        this.id = null;
        this.producto = new Producto();
    }

}
