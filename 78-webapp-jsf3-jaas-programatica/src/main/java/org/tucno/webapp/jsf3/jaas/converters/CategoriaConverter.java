package org.tucno.webapp.jsf3.jaas.converters;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.tucno.webapp.jsf3.jaas.entities.Categoria;
import org.tucno.webapp.jsf3.jaas.services.ProductoService;

import java.util.Optional;

@RequestScoped
@Named("categoriaConverter")
public class CategoriaConverter implements Converter<Categoria> {
    @Inject
    private ProductoService productoService;

    @Override
    public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String id) {
        if (id == null || id.isEmpty()) return null;

        Optional<Categoria> categoria = productoService.categoriaPorId(Long.valueOf(id));
        if (categoria.isPresent()) return categoria.get();

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {
        if (categoria == null) return "0";
        return String.valueOf(categoria.getId());
    }
}
