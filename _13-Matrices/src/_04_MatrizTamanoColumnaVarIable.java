public class _04_MatrizTamanoColumnaVarIable {
    public static void main(String[] args) {
        int[][] numeros = new int[3][];
        numeros[0] = new int[2];
        numeros[1] = new int[3];
        numeros[2] = new int[4];

        // Mostrar la longitud de la matriz
        System.out.println("Longitud matriz: " + numeros.length);
        // Mostrar la longitud de cada fila
        System.out.println("Longitud fila 0: " + numeros[0].length);
        System.out.println("Longitud fila 1: " + numeros[1].length);
        System.out.println("Longitud fila 2: " + numeros[2].length);

        // Asignar valores a la matriz
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                numeros[i][j] = i * j;
            }
        }

        // Mostar la matriz
        System.out.println("\nMatriz: ");
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.print( numeros[i][j] + "\t" );
            }
            System.out.println();
        }
    }
}
