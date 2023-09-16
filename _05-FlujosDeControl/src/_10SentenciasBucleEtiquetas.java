public class _10SentenciasBucleEtiquetas {
    public static void main(String[] args) {
        bucle1: // Esto es una etiqueta para el bucle
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    continue bucle1; // Esto es un salto a la etiqueta bucle1
                }
                System.out.print("[i = " + i + ", j = " + j + "]");
            }
        }
        
        System.out.println("\n============================================");
        
        etiqueta:
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                if (i == 2) {
                    break etiqueta; // Esto es un salto a la etiqueta bucle1
                }
                System.out.print("[i = " + i + ", j = " + j + "]");
            }
        }
    }
}
