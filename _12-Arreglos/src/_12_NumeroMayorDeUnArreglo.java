import java.util.Scanner;

public class _12_NumeroMayorDeUnArreglo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[5];
        
        // Llenar el arreglo
        System.out.println("Ingrese 5 números enteros: ");
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese un número: ");
            numeros[i] = entrada.nextInt();
        }
        
        // Encontrar el número mayor
        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        
        // Otro método
        int max = 0;
        for ( int i = 1; i < numeros.length; i++) {
            max = (numeros[max] > numeros[i]) ? max : i;
        }
        
        // Mostrar el número mayor
        System.out.println("\nEl número mayor es: " + mayor);
        System.out.println("El número mayor es: " + numeros[max]);
    }
}
