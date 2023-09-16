public class _06_MatrizSimetrica {
    public static void main(String[] args) {
        // Matriz simétrica 4x4
        int[][] matriz = {
                {1, 2, 3, 4},
                {2, 5, 6, 7},
                {3, 6, 8, 9},
                {4, 7, 9, 10}
        };

        boolean simetrica = true;

        // Recorrer la matriz con for
        int i, j;
        i = 0;
        salir: while (i < matriz.length) {
            j = 0;
            while (simetrica && j < i) {
                if (matriz[i][j] != matriz[j][i]) {
                    simetrica = false;
                    break salir;
                }
                j++;
            }
            i++;
        }

        // Recorrer la matriz con for
        salir: for (int k = 0; k < matriz.length; k++) {
            for (int l = 0; l < k; l++) {
                if (matriz[k][l] != matriz[l][k]) {
                    simetrica = false;
                    break salir;
                }
            }
        }

        // Mostrar el resultado
        if (simetrica) {
            System.out.println("La matriz es simétrica");
        } else {
            System.out.println("La matriz no es simétrica");
        }
    }
}
