public class _11SentenciasBucleEtiquetasBuscar {
    public static void main(String[] args) {
        String frase = "tres tristes tigres comen trigo en un trigal";
        int maxFrase = frase.length();
        
        String palabra = "trigo";
        int maxPalabra = palabra.length();
        
        char letra = 'g';
        
        int contador = 0;
        
        buscar:
        for (int i = 0; i < maxFrase; i++) {
            int k = i;
            for (int j = 0; j < maxPalabra; j++) {
                if (frase.charAt(k++) != palabra.charAt(j)) {
                    continue buscar;
                }
            }
            contador++;
        }
        
        System.out.println("Encontrados " + contador + " veces la palabra " + palabra + " en la frase.");
    }
}
