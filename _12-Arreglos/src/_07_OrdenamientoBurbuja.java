public class _07_OrdenamientoBurbuja {
    public static void main(String[] args) {
        String[] productos = {
                "Kingston Pendrive 64GB",
                "Samsung Galaxy",
                "Disco Duro SSD Samsung Externo",
                "Asus Notebook",
                "MacBook Air",
                "Chromecast 4ta Generación",
                "Bicicleta Oxford"
        };
        int totalProductos = productos.length;
        
        // Ordenamiento Burbuja
        int contador = 0;
        for (int i = 0; i < totalProductos; i++) {
            for (int j = 0; j < totalProductos; j++) {
                if (productos[i].compareTo(productos[j]) < 0) {
                    String auxiliar = productos[i];
                    productos[i] = productos[j];
                    productos[j] = auxiliar;
                }
                contador++;
            }
        }
        
        // Imprimimos el arreglo
        for (int i = 0; i < totalProductos; i++) {
            System.out.println("Para indice " + i + " : " + productos[i]);
        }
        
        System.out.println("\ncontador = " + contador);
    }
}
