package org.tucno.apiservlet.webapp.auth.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// @SessionScoped: Anotación que indica que la instancia de la clase es un bean de sesión.
// Esto significa que la instancia de la clase se mantendrá viva durante toda la sesión del usuario.
@SessionScoped
// @Named: Anotación que indica que la instancia de la clase es un bean de CDI.
// Por defecto, el nombre del bean es el nombre de la clase con la primera letra en minúscula.
@Named
// La clase siempre debe tener siempre un constructor sin argumentos.
// La clase debe ser serializable para que pueda ser almacenada en la sesión.
public class Carro implements Serializable {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public void addItem(ItemCarro item) {
        if (this.items.contains(item)) {
            Optional<ItemCarro> optionalItemCarro = this.items.stream()
                .filter(i -> i.equals(item))
                .findAny();

            if (optionalItemCarro.isPresent()) {
                ItemCarro i = optionalItemCarro.get();
                i.setCantidad(i.getCantidad() + 1);
            }

            return;
        }

        this.items.add(item);
    }

    public double getTotal() {
        return this.items.stream()
            .mapToDouble(ItemCarro::getImporte) // Se puede reemplazar por i -> i.getImporte()
            .sum();
    }

    public void removeProductos(List<String> productoIds) {
        if (productoIds != null) {
            productoIds.forEach(this::removeProducto);
        }
    }

    public void removeProducto(String productoId) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> items.remove(itemCarro));
    }

    public void updateCantidad(String productoId, int cantidad) {
        Optional<ItemCarro> producto = findProducto(productoId);
        producto.ifPresent(itemCarro -> itemCarro.setCantidad(cantidad));
    }

    private Optional<ItemCarro> findProducto(String productoId) {
        return  items.stream()
                .filter(itemCarro -> productoId.equals(Long.toString(itemCarro.getProducto().getId())))
                .findAny();
    }
}
