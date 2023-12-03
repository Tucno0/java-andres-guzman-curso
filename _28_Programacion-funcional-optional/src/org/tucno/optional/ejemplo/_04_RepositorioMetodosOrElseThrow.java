package org.tucno.optional.ejemplo;

import org.tucno.optional.ejemplo.models.Computador;
import org.tucno.optional.ejemplo.respositorio.ComputadorRepositorio;
import org.tucno.optional.ejemplo.respositorio.Repositorio;

import java.util.Optional;

public class _04_RepositorioMetodosOrElseThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        // orElseThrow - Devuelve el valor si existe o lanza una excepcion si no existe
        Computador pc = repositorio.filtrar("MacBook Pro").orElseThrow(
                () -> new IllegalArgumentException("No existe")
        );

        String extension = Optional.ofNullable("documento.pdf")
                .filter(nombre -> nombre.contains("."))
                .map(nombre -> nombre.substring(nombre.lastIndexOf(".") + 1))
                .orElseThrow(() -> new IllegalStateException("Extension no encontrada"));

        System.out.println(extension);
    }

    public  static Computador valorDefecto() {
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP Omen", "OMEN 15");
    }
}
