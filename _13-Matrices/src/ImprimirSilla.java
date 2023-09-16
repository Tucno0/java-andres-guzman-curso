import java.util.Scanner;

public class ImprimirSilla {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el tamaño de la matriz silla (nxn): ");
        int n = entrada.nextInt();

        if (n <= 0) {
            System.out.println("El tamaño de la matriz debe ser mayor que 0");
            System.exit(0); // Terminar el programa
        }

        int[][] silla = new int[n][n];

        // Llenar la matriz silla
        for (int i = 0; i < silla.length; i++) {
            for (int j = 0; j < silla[i].length; j++) {
                if (j == 0 || i == n/2 || (i >= n/2 && j == n - 1)) {
                    silla[i][j] = 1;
                }
            }
        }

        // Mostrar la matriz silla
        System.out.println("Matriz silla:");
        for (int i = 0; i < silla.length; i++) {
            for (int j = 0; j < silla[i].length; j++) {
                System.out.print(silla[i][j]);
            }
            System.out.println();
        }
    }
}
