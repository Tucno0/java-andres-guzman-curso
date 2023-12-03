package org.tucno.optional.ejemplo;

import org.tucno.optional.ejemplo.models.Computador;
import org.tucno.optional.ejemplo.respositorio.ComputadorRepositorio;
import org.tucno.optional.ejemplo.respositorio.Repositorio;

import java.util.Optional;

public class _02_Repositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Optional<Computador> pc = repositorio.filtrar("asus ");

       pc.ifPresentOrElse(System.out::println, () -> System.out.println("No se encontró el computador."));
    }
}
