import java.util.Scanner;

public class _21_EliminarElemento {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int[] numeros = new int[10];
        
        // Introducir números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Introduce un número: ");
            numeros[i] = teclado.nextInt();
        }
        
        // Posición del número a eliminar
        System.out.print("\nIntroduce la posición del número a eliminar 0 - 9: ");
        int posicion = teclado.nextInt();
        
        // Desplazar números
        for (int i = posicion; i < numeros.length - 1; i++) {
            numeros[i] = numeros[i + 1];
        }
        
        // Mostrar números
        System.out.println("\nNúmeros ordenados:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + " => " + numeros[i]);
        }
        
        // copiar array
        int[] numeros2 = new int[numeros.length - 1];
        System.arraycopy(numeros, 0, numeros2, 0, numeros2.length); // Aqui se copia el array numeros en el array numeros2
        
        // Mostrar números2
        System.out.println("\nNúmeros2 ordenados:");
        for (int i = 0; i < numeros2.length; i++) {
            System.out.println(i + " => " + numeros2[i]);
        }
    }
}
