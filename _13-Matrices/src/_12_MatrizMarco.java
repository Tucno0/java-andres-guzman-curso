public class _12_MatrizMarco {
    public static void main(String[] args) {
        int[][] matrizMarco = new int[5][5];

        // Llenar la matriz marco
        for (int i = 0; i < matrizMarco.length; i++) {
            for (int j = 0; j < matrizMarco[i].length; j++) {
                if (i == 0
                    || i == matrizMarco.length - 1
                    || j == 0
                    || j == matrizMarco[i].length - 1
                    || i == j
                    || i + j == matrizMarco.length - 1
                ) {
                    matrizMarco[i][j] = 1;
                }
            }
        }

        // Mostrar la matriz marco
        System.out.println("Matriz marco:");
        for (int i = 0; i < matrizMarco.length; i++) {
            for (int j = 0; j < matrizMarco[i].length; j++) {
                System.out.print(matrizMarco[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
