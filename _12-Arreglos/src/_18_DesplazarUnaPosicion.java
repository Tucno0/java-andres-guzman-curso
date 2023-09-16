import java.util.Scanner;

public class _18_DesplazarUnaPosicion {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a = new int[10];
        
        // Llenar el arreglo
        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Desplazar una posición
        int aux = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            a[i +1] = a[i];
        }
        a[0] = aux;
        
        // Imprimir arreglo
        System.out.println("\nEl arreglo desplazado una posición es: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
