public class _01_MatrizEnteros {
    public static void main(String[] args) {

        int[][] numeros = new int[2][4];

        numeros[0][0] = 1;
        numeros[0][1] = 2;
        numeros[0][2] = 3;
        numeros[0][3] = 4;

        numeros[1][0] = 5;
        numeros[1][1] = 6;
        numeros[1][2] = 7;
        numeros[1][3] = 8;

        System.out.println("Numero de filas: " + numeros.length);
        System.out.println("Numero de columnas: " + numeros[0].length);

        System.out.println("\nPrimer elemento de la matriz: " + numeros[0][0]);
        System.out.println("Ultimo elemento de la matriz: " + numeros[numeros.length -1 ][numeros[1].length -1]);

        int numero1 = numeros[0][0];
        int numero2 = numeros[0][1];
        int numero3 = numeros[0][2];
        int numero4 = numeros[0][3];
        int numero5 = numeros[1][0];
        int numero6 = numeros[1][1];
        int numero7 = numeros[1][2];
        int numero8 = numeros[1][3];

        System.out.println("\nFila 1: " + numero1 + " " + numero2 + " " + numero3 + " " + numero4);
        System.out.println("Fila 2: " + numero5 + " " + numero6 + " " + numero7 + " " + numero8);

        System.out.println("\nnumero1 = " + numero1);
        System.out.println("numero2 = " + numero2);
        System.out.println("numero3 = " + numero3);
        System.out.println("numero4 = " + numero4);

        System.out.println("\nnumero5 = " + numero5);
        System.out.println("numero6 = " + numero6);
        System.out.println("numero7 = " + numero7);
        System.out.println("numero8 = " + numero8);
    }
}
