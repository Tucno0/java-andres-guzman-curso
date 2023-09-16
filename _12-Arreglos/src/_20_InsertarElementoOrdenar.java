import java.util.Scanner;

public class _20_InsertarElementoOrdenar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int[] numeros = new int[7];
        int numero, posicion;
        
        // Introducir números
        for (int i = 0; i < numeros.length - 1; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = teclado.nextInt();
        }
        
        // Introducir número a insertar
        System.out.print("Introduce un número a insertar: ");
        numero = teclado.nextInt();
        posicion = 0;
        
        // Buscar posición
        while (posicion < numeros.length - 1 && numero > numeros[posicion]) {
            posicion++;
        }
        
        // Desplazar números
        for (int i = numeros.length - 2; i >= posicion; i--) {
            numeros[i + 1] = numeros[i];
        }
        numeros[posicion] = numero;
        
        // Mostrar números
        System.out.println("Números ordenados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
    }
}
