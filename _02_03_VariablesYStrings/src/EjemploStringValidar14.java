public class EjemploStringValidar14 {
    public static void main(String[] args) {
        String curso = null;
        
        // Validar si un String es nulo
        boolean esNulo = curso == null;
        System.out.println("esNulo = " + esNulo);
        
        if ( esNulo ) {
            curso = "b ";
        }
        
        // Validar si un String está vacío
        boolean esVacio = curso.length() == 0;
        System.out.println("esVacio = " + esVacio);
        
        // Validar si un String está vacío (Java 6 o inferior)
        boolean esVacio2 = curso.isEmpty();
        System.out.println("esVacio2 = " + esVacio2);
        
        // Validar si un String contiene solo espacios en blanco
        boolean esBlanco = curso.isBlank();
        System.out.println("esBlanco = " + esBlanco);
        
        if ( !esBlanco ) {
            System.out.println(curso.toUpperCase());
            System.out.println("Bienvenido al curso ".concat(curso));
        }
        
//        System.out.println(curso.concat(" desde cero!")); // No se puede concatenar a un valor nulo
//        System.out.println("Bienvenido al curso ".concat(curso)); // No se puede concatenar un valor nulo
//        System.out.println("Bienvenido al curso " + curso); // Esto devuelve "Bienvenido al curso null"
    }
}
