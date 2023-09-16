public class _11_MatrizIdentidad {
    public static void main(String[] args) {
        int[][] matrizIdentidad = new int[5][5];

        // Llenar la matriz identidad
        for (int i = 0; i < matrizIdentidad.length; i++) {
            for (int j = 0; j < matrizIdentidad[i].length; j++) {
                if (i == j) {
                    matrizIdentidad[i][j] = 1;
                }
            }
        }

        // Mostrar la matriz identidad
        System.out.println("Matriz identidad:");
        for (int i = 0; i < matrizIdentidad.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizIdentidad[i].length; j++) {
                System.out.print(matrizIdentidad[i][j] + "\t");
            }
            System.out.println("|");
        }
    }
}
