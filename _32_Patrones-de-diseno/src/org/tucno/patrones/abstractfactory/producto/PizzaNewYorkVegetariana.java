package org.tucno.patrones.abstractfactory.producto;

import org.tucno.patrones.abstractfactory.PizzaProducto;

public class PizzaNewYorkVegetariana extends PizzaProducto {
    public PizzaNewYorkVegetariana() {
        super(); // Llamada al constructor de la clase padre PizzaProducto para inicializar la lista de ingredientes
        nombre = "Pizza vegetariana New York";
        masa = "Masa integral vegana";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Cebolla");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min. a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
