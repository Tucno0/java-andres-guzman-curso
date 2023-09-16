public class _08_OrdenamientoBurbujaOptimizado {
    public static void main(String[] args) {
    // ORDENAMIENTO BURBUJA PARA STRINGS
        String[] productos = {
                "Kingston Pendrive 64GB",
                "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook",
                "MacBook Air",
                "Chromecast 4ta Generación",
                "Bicicleta Oxford"
        };
        
        // Ordenamos el arreglo de Strings
        sortBurbuja(productos);
        
        // Imprimimos el arreglo
        imprimir(productos);
        
    // ORDENAMIENTO BURBUJA PARA ENTEROS
        Integer[] numeros = new Integer[4];
        
        numeros[0] = 20;
        numeros[1] = 15;
        numeros[2] = 18;
        numeros[3] = 12;
        
        // Ordenamos el arreglo de enteros
        sortBurbuja(numeros);
        
        // Imprimimos el arreglo
        imprimir(numeros);
    }
    
    public static void sortBurbuja( Object[] arreglo) {
        int total = arreglo.length;
        int contador = 0;
        
        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if ( ( (Comparable)arreglo[j+1] ).compareTo(arreglo[j]) < 0 ) {
                    Object auxiliar = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = auxiliar;
                }
                contador++;
            }
        }
        System.out.println("\ncontador = " + contador + " interacciones");
    }
    
    public static void imprimir(Object[] arreglo) {
        int total = arreglo.length;
        
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + arreglo[i]);
        }
    }
}
