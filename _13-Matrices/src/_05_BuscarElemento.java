public class _05_BuscarElemento {
    public static void main(String[] args) {

        int[][] matrizEnteros = {
            {35, 20, 15, 10},
            {40, 30, 25, 20},
            {45, 35, 30, 15}
        };

        int elementoBuscar = 15;
        boolean encontrado = false;

        // Buscar el elemento en la matriz
        int i;
        int j = 0;
        buscar: for (i = 0; i < matrizEnteros.length; i++) {
            for (j = 0; j < matrizEnteros[i].length; j++) {
                if (matrizEnteros[i][j] == elementoBuscar) {
                    encontrado = true;
                    break buscar;
                }
            }
        }

        // Mostrar el resultado de la busqueda
        if (encontrado) {
            System.out.println("Elemento " + elementoBuscar + " encontrado en la fila " + i + " columna " + j);
        } else {
            System.out.println("Elemento " + elementoBuscar + " no encontrado");
        }

        // Imprimir la matriz con forEach
        System.out.println("\nMatriz de enteros: ");
        for (int[] fila : matrizEnteros) {
            for ( int entero : fila) {
                System.out.print( entero + "\t");
            }
            System.out.println();
        }
    }
}
