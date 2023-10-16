package org.tucno.poointerfaces.imprenta;

import org.tucno.poointerfaces.imprenta.modelo.*;

public class _01_EjemploImprenta {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo(
                new Persona("John", "Doe"),
                "Ingeniero de Sistemas",
                "Resumen laboral..."
        );
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador FullStack")
                .addExperiencia("Angular");

        Libro libro = new Libro(
                new Persona("Erich", "Gamma"),
                "Patrones de Diseño",
                Genero.PROGRAMACION
        );
        libro.addPagina(new Pagina("Patrón Singleton"))
                .addPagina(new Pagina("Patrón Observador"))
                .addPagina(new Pagina("Patrón Factory"))
                .addPagina(new Pagina("Patrón Composite"))
                .addPagina(new Pagina("Patrón Facade"));

        Informe informe = new Informe(
                new Persona("Martin", "Fowler"),
                new Persona("James", "Gosling"),
                "Estudio sobre microservicios"
        );

        Imprimible.imprimir(cv);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(libro);

        System.out.println(Imprimible.TEXTO_DEFECTO);

        // Clase anonima que implementa la interfaz Imprimible
        Imprimible documento = new Imprimible() {
            @Override
            public String imprimir() {
                return "Documento sin métodos de la interfaz";
            }
        };
        Imprimible.imprimir(documento);
    }

}
