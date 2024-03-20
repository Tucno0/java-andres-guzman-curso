package org.tucno.patrones.abstractfactory.factories;

import org.tucno.patrones.abstractfactory.producto.PizzaProducto;
import org.tucno.patrones.abstractfactory.producto.PizzaCaliforniaPepperoni;
import org.tucno.patrones.abstractfactory.producto.PizzaCaliforniaQueso;
import org.tucno.patrones.abstractfactory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory {

    @Override
    public PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "queso" -> new PizzaCaliforniaQueso();
            default -> null;
        };
    }
}
