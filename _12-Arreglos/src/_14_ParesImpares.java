import java.util.Scanner;

public class _14_ParesImpares {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a, pares, impares;
        int totalPares = 0, totalImpares = 0;
        a = new int[10];
        
        // Llenar el arreglo
        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Contar pares e impares
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) { // Si es par
                totalPares++;
            } else { // Si es impar
                totalImpares++;
            }
        }
        
        // Crear arreglos
        pares = new int[totalPares];
        impares = new int[totalImpares];
        
        // Llenar arreglos
        int j = 0, k = 0; // variables para controlar los índices de los arreglos
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) { // Si es par
                pares[j++] = a[i];
            } else { // Si es impar
                impares[k++] = a[i];
            }
        }
        
        // Mostrar arreglos
        System.out.println("\nArreglo original");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        
        System.out.println("\nArreglo de pares");
        for (int i = 0; i < pares.length; i++) {
            System.out.print(pares[i] + " ");
        }
        
        System.out.println("\nArreglo de impares");
        for (int i = 0; i < impares.length; i++) {
            System.out.print(impares[i] + " ");
        }
    }
}
