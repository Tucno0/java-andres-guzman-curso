public class EjemploStringConcatenacion11 {
    public static void main(String[] args) {
        // 003 Concatenando String
        String curso = "Programación Java";
        String profesor = "Andrés Guzmán";
        
        String detalle = curso + " con el instructor " + profesor;
        System.out.println("detalle = " + detalle);
        
        int numeroA = 10;
        int numeroB = 5;
        
        System.out.println( detalle + (numeroA + numeroB) ); // Concatenación de String con números
        System.out.println( numeroA + numeroB + detalle ); // Suma de números con String
        
        String detalle2 = curso.concat(" con ").concat(profesor);
        System.out.println("\ndetalle2 = " + detalle2);
    }
}
