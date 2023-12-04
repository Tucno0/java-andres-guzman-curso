package org.tucno.patrones.decorator.ejemplo;

import org.tucno.patrones.decorator.Formateable;
import org.tucno.patrones.decorator.Texto;
import org.tucno.patrones.decorator.decorador.MayusculaDecorador;
import org.tucno.patrones.decorator.decorador.ReemplazarEspacioDecorador;
import org.tucno.patrones.decorator.decorador.ReversaDecorador;
import org.tucno.patrones.decorator.decorador.SubrayadoDecorador;

public class _03_EjemploDecorador {
    public static void main(String[] args) {
        // Crea un objeto Texto
        Formateable texto = new Texto("Hola que tal");

        // Crea un objeto Decorador con el objeto Texto como parámetro
        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);

        // Crea un objeto Decorador con el objeto Decorador anterior como parámetro
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);

        ReemplazarEspacioDecorador reemplazar = new ReemplazarEspacioDecorador(reversa);

        // Crea un objeto Decorador con el objeto Decorador anterior como parámetro
        SubrayadoDecorador subrayado = new SubrayadoDecorador(reemplazar);

        // Imprime el texto con el formato
        System.out.println(subrayado.darFormato());
    }
}
