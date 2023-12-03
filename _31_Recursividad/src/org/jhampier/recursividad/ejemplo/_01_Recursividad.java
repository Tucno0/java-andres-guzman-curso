package org.jhampier.recursividad.ejemplo;

import org.jhampier.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class _01_Recursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATC");
        Componente poder = new Componente("Fuente de poder 700W");
        Componente placaMadre = new Componente("Placa madre ASUS");

        Componente cpu = new Componente("Procesador Intel i7");
        Componente ventilador = new Componente("Ventilador de CPU");
        Componente disipador = new Componente("Disipador");

        Componente tv = new Componente("NVIDIA RTX 3080 8GB");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4GB RAM");
        Componente gpuRam2 = new Componente("4GB RAM");
        Componente gpuVentiladores = new Componente("Ventiladores");

        Componente ram = new Componente("Memoria RAM 32GB");
        Componente ssd = new Componente("Disco SSD 2TB");

        cpu.addComponente(ventilador)
                .addComponente(disipador);

        tv.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);

        placaMadre.addComponente(cpu)
                .addComponente(tv)
                .addComponente(ram)
                .addComponente(ssd);

        pc.addComponente(poder)
                .addComponente(placaMadre)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Mouse"));

//        metodoRecursivo(pc, 0);

            metodoRecursivoJava8(pc, 0)
                    .forEach( componente ->
                            System.out.println("\t".repeat(componente.getNivel()) + componente.getNombre())
                    );
    }

    public static void metodoRecursivo( Componente componente, int nivel ) {
        System.out.println("\t".repeat(nivel) + componente.getNombre());

        if (componente.tieneHijos()) {
            for (Componente hijo : componente.getHijos()) {
                metodoRecursivo(hijo, nivel + 1);
            }
        }
    }

    public static Stream<Componente> metodoRecursivoJava8 (Componente componente, int nivel ) {
        componente.setNivel(nivel);

        return Stream.concat(
                Stream.of(componente),
                componente.getHijos().stream()
                        .flatMap( hijo -> metodoRecursivoJava8(hijo, nivel + 1) )

        );
    }
}
