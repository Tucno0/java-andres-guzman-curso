import java.util.Scanner;

public class _01SentenciaIfElse {
    public static void main(String[] args) {
        float promedio = 6.5f;
        
        if ( promedio >= 6.5) {
            System.out.println("Felicitaciones, excelente promedio!");
        } else if ( promedio >= 6.0 ) {
            System.out.println("Muy buen promedio!");
        } else if ( promedio >= 5.5 ) {
            System.out.println("Buen promedio!");
        } else if ( promedio >= 5.0 ) {
            System.out.println("Regular, necesitas esforzarte un poco mas!");
        } else if ( promedio >= 4.0 ) {
            System.out.println("Insuficiente, necesitas esforzarte mas!");
        } else {
            System.out.println("Reprobado, necesitas esforzarte mucho mas!");
        }
        
        System.out.println("Tu promedio es: " + promedio);
    }
}
