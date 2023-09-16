public class _03_MatrizStringsSimple {
    public static void main(String[] args) {
        String[][] nombres = {{"Juan", "Pedro"}, {"Maria", "Luis"}, {"Lucas", "Pancha"}};

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
