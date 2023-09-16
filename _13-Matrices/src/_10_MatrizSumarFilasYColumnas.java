public class _10_MatrizSumarFilasYColumnas {
    public static void main(String[] args) {
        int[][] a = {
                {1,  2,  3},
                {4,  5,  6},
                {7,  8,  9}
        };

        int sumaFilas, sumaColumnas;

        // Sumar las filas y las columnas
        for (int i = 0; i < a.length; i++) {
            sumaFilas = 0;
            sumaColumnas = 0;

            for (int j = 0; j < a[i].length; j++) {
                sumaFilas += a[i][j];
                sumaColumnas += a[j][i];
            }
            System.out.println("\nSuma fila " + i + ": \t" + sumaFilas);
            System.out.println("Suma columna " + i + ": " + sumaColumnas);
        }

    }
}
