package org.tucno.patrones.abstractfactory.producto;

import org.tucno.patrones.abstractfactory.PizzaProducto;

public class PizzaNewYorkItaliana extends PizzaProducto {
    public PizzaNewYorkItaliana() {
        super(); // Llamada al constructor de la clase padre PizzaProducto para inicializar la lista de ingredientes
        nombre = "Pizza italiana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate italiano";
        ingredientes.add("Queso mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Jamon serrano");
        ingredientes.add("Choricillo");
        ingredientes.add("Champiñones");
    }
    @Override
    public void cocinar() {
        System.out.println("Cocinando por 20 min. a 120°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas triangulares");
    }
}
