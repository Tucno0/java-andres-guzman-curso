import java.util.Scanner;

public class OrdenUltimoPrimero {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[10];
        
        // Llenamos el arreglo
        System.out.println("Ingrese 10 numeros");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            numeros[i] = entrada.nextInt();
        }
        
        // Imprimimos el arreglo (ultimo : primero)
        System.out.println("\nImprimimos el arreglo (ultimo : primero)");
        for (int i = 0; i < numeros.length - i; i++) {
            System.out.print("numeros[" + (numeros.length - 1 - i) + "] = " + numeros[numeros.length - 1 - i] + "\t");
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }
    }
}
