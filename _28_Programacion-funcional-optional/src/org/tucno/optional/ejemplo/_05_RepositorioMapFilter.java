package org.tucno.optional.ejemplo;

import org.tucno.optional.ejemplo.models.Computador;
import org.tucno.optional.ejemplo.models.Fabricante;
import org.tucno.optional.ejemplo.respositorio.ComputadorRepositorio;
import org.tucno.optional.ejemplo.respositorio.Repositorio;

public class _05_RepositorioMapFilter {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String fab = repositorio.filtrar("Asus ROG")
                .flatMap(c -> c.getProcesador())
                .flatMap(p -> p.getFabricante())
                .filter(f -> f.getNombre().equalsIgnoreCase("intel"))
                .map(f -> f.getNombre())
                .orElse("Desconocido");

        System.out.println(fab);

    }
}
