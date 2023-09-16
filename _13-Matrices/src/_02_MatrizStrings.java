public class _02_MatrizStrings {
    public static void main(String[] args) {
        String[][] nombres = new String[3][2];

        nombres[0][0] = "Juan";
        nombres[0][1] = "Pedro";
        nombres[1][0] = "Maria";
        nombres[1][1] = "Luis";
        nombres[2][0] = "Lucas";
        nombres[2][1] = "Pancha";

        // Imprimir la matriz con for
        System.out.println("Interando con for:");
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                System.out.print(nombres[i][j] + "\t");
            }
            System.out.println();
        }

        // Imprimir la matriz con foreach
        System.out.println("\nInterando con foreach:");
        for (String[] fila : nombres) {
            for (String nombre : fila) {
                System.out.print(nombre + "\t");
            }
            System.out.println();
        }
    }
}
