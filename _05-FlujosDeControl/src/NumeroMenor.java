import java.util.Scanner;

public class NumeroMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingresa la cantidad de numeros a comparar (mínimo 10): ");
        int cantidad = scanner.nextInt();
        int[] numeros = new int[cantidad];
        
        if (cantidad >= 10) {
            for ( int i = 0; i < cantidad; i++) {
                System.out.print("Ingrese un numero:");
                numeros[i] = scanner.nextInt();
            }
            
            int menor = numeros[0];
            
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] < menor) {
                    menor = numeros[i];
                }
            }
            
            if (menor < 10) {
                System.out.println("El número " + menor + " es menor que 10!");
            } else {
                System.out.println("El numero " + menor + " es igual o mayor que 10!");
            }
        } else {
            System.out.println("La cantidad debe ser mayor a 10");
            main(args);
        }
    }
}
