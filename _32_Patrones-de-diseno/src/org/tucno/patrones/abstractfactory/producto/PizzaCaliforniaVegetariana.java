package org.tucno.patrones.abstractfactory.producto;

import org.tucno.patrones.abstractfactory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza vegetariana California";
        masa = "Masa delgada light";
        salsa = "Salsa barbacoa";
        ingredientes.add("Queso vegano");
        ingredientes.add("Espinaca");
        ingredientes.add("Aceitunas");
        ingredientes.add("Cebolla");
        ingredientes.add("Berenjena");
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
