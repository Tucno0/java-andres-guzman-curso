import java.util.Scanner;

public class _22_InsertarIncrementarTamanoArray {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a = new int[10];
        int elemento, posicion, ultimo;
        
        // Llenar el arreglo
        System.out.println("Ingrese 10 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Insertar un elemento
        System.out.print("\nIngrese el número a insertar: ");
        elemento = entrada.nextInt();
        
        System.out.println("Ingrese la posición donde insertar el número: ");
        posicion = entrada.nextInt();
        
        ultimo = a[a.length - 1];
        for ( int i = a.length - 2; i >= posicion; i-- ) {
            a[i+1] = a[i];
        }
        
        // Copiar arreglo
        int[] b = new int[a.length + 1];
        System.arraycopy(a, 0, b, 0, a.length);
        b[posicion] = elemento;
        b[b.length - 1] = ultimo;
        
        // Imprimir arreglo
        System.out.println("\nEl arreglo con el número insertado es: ");
        for (int i = 0; i < b.length; i++) {
            System.out.println("b[" + i + "] = " + b[i]);
        }
    }
}
