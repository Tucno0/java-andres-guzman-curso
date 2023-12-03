package org.tucno.optional.ejemplo;

import org.tucno.optional.ejemplo.models.Computador;
import org.tucno.optional.ejemplo.respositorio.ComputadorRepositorio;
import org.tucno.optional.ejemplo.respositorio.Repositorio;

import java.util.Optional;

public class _03_RepositorioMetodosOrElse {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

//        Computador defecto = new Computador("HP Omen", "OMEN 15");

        // orElse - Devuelve el valor si existe o el valor por defecto, de todas formas se ejecuta
        Computador pc = repositorio.filtrar("MacBook Pro").orElse(valorDefecto());
        System.out.println(pc);

        // orElseGet - Devuelve el valor si existe o el valor por defecto generado por una funcion lambda
        // no se ejecuta si el valor existe
        pc = repositorio.filtrar("macbook ").orElseGet(() -> valorDefecto());
        System.out.println(pc);
    }

    public  static Computador valorDefecto() {
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP Omen", "OMEN 15");
    }
}
