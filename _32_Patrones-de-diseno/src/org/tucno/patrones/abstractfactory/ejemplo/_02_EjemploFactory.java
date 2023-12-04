package org.tucno.patrones.abstractfactory.ejemplo;

import org.tucno.patrones.abstractfactory.PizzaProducto;
import org.tucno.patrones.abstractfactory.PizzeriaCaliforniaFactory;
import org.tucno.patrones.abstractfactory.PizzeriaNewYorkFactory;
import org.tucno.patrones.abstractfactory.PizzeriaZonaAbstractFactory;

public class _02_EjemploFactory {
    public static void main(String[] args) {

        PizzeriaZonaAbstractFactory pizzeriaNewYork = new PizzeriaNewYorkFactory();
        PizzaProducto pizzaNewYork = pizzeriaNewYork.ordenarPizza("pepperoni");
        System.out.println("Pedimos una " + pizzaNewYork.getNombre() + "\n");

        PizzeriaZonaAbstractFactory pizzeriaCalifornia = new PizzeriaCaliforniaFactory();
        PizzaProducto pizzaCalifornia = pizzeriaCalifornia.ordenarPizza("queso");
        System.out.println("Pedimos una " + pizzaCalifornia.getNombre() + "\n");

    }
}
