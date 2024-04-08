package org.tucno.apiservlet.webapp.jstl.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
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
