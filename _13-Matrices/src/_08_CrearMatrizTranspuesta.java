public class _08_CrearMatrizTranspuesta {
    public static void main(String[] args) {
        int[][] a, b;
        a = new int[8][4];
        b = new int[4][8];

        // Asignar valores a la matriz a
        System.out.println("Matriz a original: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                a[i][j] = i + j * 3;
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("|");
        }

        // Haciendo la matriz transpuesta
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[j][i] = a[i][j];
            }
        }

        // Mostrar la matriz transpuesta
        System.out.println("\nMatriz b transpuesta:");
        for (int i = 0; i < 4; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println("|");
        }
    }
}
