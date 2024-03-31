package org.tucno.apiservlet.webapp.listeners.models;

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
}
