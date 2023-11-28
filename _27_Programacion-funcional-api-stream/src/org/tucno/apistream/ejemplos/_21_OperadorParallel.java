package org.tucno.apistream.ejemplos;

import org.tucno.apistream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class _21_OperadorParallel {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Raúl", "López"));
        lista.add(new Usuario("Víctor", "García"));
        lista.add(new Usuario("Javier", "Martínez"));
        lista.add(new Usuario("Jesús", "Pérez"));
        lista.add(new Usuario("Jorge", "Hernández"));
        lista.add(new Usuario("Javier", "García"));
        lista.add(new Usuario("Javier", "Martínez"));
        lista.add(new Usuario("javier", "Rodríguez"));

        // Operador Parallel
        // Ejecuta el stream en paralelo (en varios hilos) y devuelve el primer resultado que encuentre
        // Si no encuentra ningún resultado, devuelve un Optional vacío

        long t1 = System.currentTimeMillis();
        String usuario = lista.stream()
                .parallel() // Ejecuta el stream en paralelo (en varios hilos)
                .map( u -> u.toString().toUpperCase())
                .peek( n -> {
                    System.out.println("Hilo: " + Thread.currentThread().getName() + " - " + n);
                })
                .flatMap( u -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (u.contains("Javier".toUpperCase())) {
                        return Stream.of(u);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("No hay coincidencias");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo: " + (t2 - t1));
        System.out.println("usuario = " + usuario);

    }
}
