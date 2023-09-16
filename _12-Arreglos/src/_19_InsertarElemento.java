import java.util.Scanner;

public class _19_InsertarElemento {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a = new int[10];
        
        // Llenar el arreglo
        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Insertar un elemento
        System.out.print("\nIngrese el número a insertar: ");
        int numero = entrada.nextInt();
        
        System.out.println("Ingrese la posición donde insertar el número: ");
        int posicion = entrada.nextInt();
        
        for ( int i = a.length - 2; i >= posicion; i-- ) {
            a[i+1] = a[i];
        }
        a[posicion] = numero;
        
        // Imprimir arreglo
        System.out.println("\nEl arreglo con el número insertado es: ");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
