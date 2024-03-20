package org.tucno.patrones.abstractfactory.factories;

import org.tucno.patrones.abstractfactory.producto.PizzaProducto;

abstract public class PizzeriaZonaAbstractFactory {
    public PizzaProducto ordenarPizza(String tipo) {
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("------ Fabricando una pizza " + pizza.getNombre() + " ------");
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;
    }

    abstract public PizzaProducto crearPizza(String tipo);
}
