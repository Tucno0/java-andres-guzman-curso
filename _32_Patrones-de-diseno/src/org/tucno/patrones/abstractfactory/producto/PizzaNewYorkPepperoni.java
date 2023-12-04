package org.tucno.patrones.abstractfactory.producto;

import org.tucno.patrones.abstractfactory.PizzaProducto;

public class PizzaNewYorkPepperoni extends PizzaProducto {
    public PizzaNewYorkPepperoni() {
        super(); // Llamada al constructor de la clase padre PizzaProducto para inicializar la lista de ingredientes
        nombre = "Pizza pepperoni New York";
        masa = "Masa delgada a la piedra";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Pepperoni");
        ingredientes.add("Rodajas de cebolla");
        ingredientes.add("Aceitunas negras");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20 min. a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en triangulos");
    }
}
