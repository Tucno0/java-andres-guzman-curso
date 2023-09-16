public class _09_SumarMatrices {
    public static void main(String[] args) {

        // Sumar dos matrices de 3x3
        int[][] a = {
            {1,  2,  3},
            {4,  5,  6},
            {7,  8,  9}
        };

        int[][] b = {
            {9,  8,  7},
            {6,  5,  4},
            {3,  2,  1}
        };

        // Matriz para guardar la suma
        int[][] suma = new int[3][3];

        // Sumar las matrices
        for (int i = 0; i < suma.length; i++) {
            for (int j = 0; j < 3; j++) {
                suma[i][j] = a[i][j] + b[i][j];
            }
        }

        // Mostrar la matriz a
        System.out.println("Matriz a:");
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println("|");
        }

        // Mostrar la matriz b
        System.out.println("\nMatriz b:");
        for (int i = 0; i < b.length; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println("|");
        }

        // Mostrar la matriz suma
        System.out.println("\nMatriz suma:");
        for (int i = 0; i < suma.length; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(suma[i][j] + "\t");
            }
            System.out.println("|");
        }

    }
}
