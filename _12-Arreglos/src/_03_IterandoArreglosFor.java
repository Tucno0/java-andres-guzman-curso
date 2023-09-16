import java.util.Arrays;

public class _03_IterandoArreglosFor {
    public static void main(String[] args) {
        String[] productos = new String[7];
        int total = productos.length;
        
        // Por defecto, los elementos de un arreglo de Strings son null
        for (int i = 0; i < total; i++) {
            System.out.println("para i = " + i + " : " + productos[i]);
        }
        
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "MacBook Air";
        productos[5] = "Chromecast 4ta Generación";
        productos[6] = "Bicicleta Oxford";
        
        // Iterando los elementos de un arreglo
        System.out.println("\nIterando los elementos de un arreglo ==== usando for ====");
        for (int i = 0; i < total; i++) {
            System.out.println("para i = " + i + " : " + productos[i]);
        }

        // Ordena los elementos del arreglo
        Arrays.sort(productos);
        
        // Iterando los elementos de un arreglo con for-each
        System.out.println("\nIterando los elementos de un arreglo ordenado ==== usando foreach ====");
        for (String producto : productos) {
            System.out.println("producto = " + producto);
        }
        
        // Iterando los elementos de un arreglo con while
        System.out.println("\nIterando los elementos de un arreglo ordenado ==== usando while ====");
        int i = 0;
        while ( i < 7) {
            System.out.println("para i = " + i + " : " + productos[i]);
            i++;
        }
        
        // Iterando los elementos de un arreglo con do-while
        System.out.println("\nIterando los elementos de un arreglo ordenado ==== usando do-while ====");
        int j = 0;
        do {
            System.out.println("para j = " + j + " : " + productos[j]);
            j++;
        } while (j < 7);
    }
}
