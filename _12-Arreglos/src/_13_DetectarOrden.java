import java.util.Scanner;

public class _13_DetectarOrden {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        int[] a = new int[7];
        System.out.println("Ingrese 7 números enteros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un número: ");
            a[i] = entrada.nextInt();
        }
        
        // Detectar si el arreglo está ordenado de forma ascendente o ascendente
        boolean ascendente = false;
        boolean descendente = false;
        
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i+1]) {
                descendente = true;
            }
            if (a[i] < a[i+1]) {
                ascendente = true;
            }
        }
        
        if (ascendente && descendente) {
            System.out.println("El arreglo no está ordenado");
        } else if (ascendente) {
            System.out.println("El arreglo está ordenado de forma ascendente");
        } else if (descendente) {
            System.out.println("El arreglo está ordenado de forma descendente");
        } else {
            System.out.println("El arreglo está vacío");
        }
    }
}
