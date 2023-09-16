import java.util.Scanner;

public class _16_BuscarNumero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a = new int[10];
        
        // Llenar el arreglo
        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Buscar un número
        System.out.print("\nIngrese el número a buscar: ");
        int numero = entrada.nextInt();
        
        int i = 0;
        while (i < a.length && a[i] != numero) {
            i++;
        }
        
        if (i == a.length) {
            System.out.println("El número " + numero + " no se encuentra en el arreglo");
        } else {
            System.out.println("El número " + numero + " se encuentra en la posición " + i);
        }
    }
}
