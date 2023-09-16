import java.util.Scanner;

public class ImprimirX {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de la matriz X: ");
        int tamano = entrada.nextInt();

        if (tamano <= 0) {
            System.out.println("El tamaño de la matriz X debe ser mayor que 0");
            System.exit(0); // Terminar el programa
        }

        String[][] matrizX = new String[tamano][tamano];

        // Llenar la matriz X
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                if (i == j || i + j == matrizX.length - 1) {
                    matrizX[i][j] = "X";
                } else {
                    matrizX[i][j] = "_";
                }
            }
        }

        // Mostrar la matriz X
        System.out.println("Matriz X:");
        for (int i = 0; i < matrizX.length; i++) {
            for (int j = 0; j < matrizX[i].length; j++) {
                System.out.print(matrizX[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
