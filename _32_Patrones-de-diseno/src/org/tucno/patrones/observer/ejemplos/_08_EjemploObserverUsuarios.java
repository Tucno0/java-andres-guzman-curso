package org.tucno.patrones.observer.ejemplos;

import org.tucno.patrones.observer.UsuarioRepositorio;

public class _08_EjemploObserverUsuarios {
    public static void main(String[] args) {
        UsuarioRepositorio repositorio = new UsuarioRepositorio();

        repositorio.addObserver((observable, u) -> {
            System.out.println("Enviando correo al usuario " + u);
        });

        repositorio.addObserver((observable, u) -> {
            System.out.println("Enviando mensaje al usuario " + u);
        });

        repositorio.addObserver((observable, u) -> {
            System.out.println("Guardando info del usuario " + u);
        });

        repositorio.crearUsuario("jhon");
        repositorio.crearUsuario("jane");
    }
}
