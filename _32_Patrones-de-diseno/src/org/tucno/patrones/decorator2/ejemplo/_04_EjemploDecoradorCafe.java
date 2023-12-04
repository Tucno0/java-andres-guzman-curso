package org.tucno.patrones.decorator2.ejemplo;

import org.tucno.patrones.decorator2.Cafe;
import org.tucno.patrones.decorator2.Configurable;
import org.tucno.patrones.decorator2.decorador.ConChocolateDecorador;
import org.tucno.patrones.decorator2.decorador.ConCremaDecorador;
import org.tucno.patrones.decorator2.decorador.ConLecheDecorador;

public class _04_EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe(10f, "cafe");
        System.out.println("Cafe: " + cafe.getIngredientes() + " $" + cafe.getPrecioBase());

        Configurable cafeConCrema = new ConCremaDecorador(cafe);
        System.out.println("Cafe con crema: " + cafeConCrema.getIngredientes() + " $" + cafeConCrema.getPrecioBase());

        Configurable cafeConCremaYLeche = new ConLecheDecorador(cafeConCrema);
        System.out.println("Cafe con crema y leche: " + cafeConCremaYLeche.getIngredientes() + " $" + cafeConCremaYLeche.getPrecioBase());

        Configurable cafeConCremaYLecheYChocolate = new ConChocolateDecorador(cafeConCremaYLeche);
        System.out.println("Cafe con crema, leche y chocolate: " + cafeConCremaYLecheYChocolate.getIngredientes() + " $" + cafeConCremaYLecheYChocolate.getPrecioBase());


        Configurable capuchino = new Cafe(10f, "Cafe capuchino");
        Configurable conCrema = new ConCremaDecorador(capuchino);
        Configurable conLeche = new ConLecheDecorador(conCrema);
        System.out.println("\nPrecio del capuchino: " + conLeche.getPrecioBase());
        System.out.println("Ingredientes del capuchino: " + conLeche.getIngredientes());

        Configurable expreso = new Cafe(10f, "Cafe expreso");
        System.out.println("\nPrecio del expreso: " + expreso.getPrecioBase());
        System.out.println("Ingredientes del expreso: " + expreso.getIngredientes());
    }
}
