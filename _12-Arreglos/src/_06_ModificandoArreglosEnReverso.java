import java.util.Arrays;
import java.util.Collections;

public class _06_ModificandoArreglosEnReverso {
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
        Arrays.sort(productos); // Ordenar el arreglo
        
        for (int i = 0; i < totalProductos; i++) {
            System.out.println("productos[" + i + "] = " + productos[i]);
        }
        
        // Invertir el arreglo
//        invertirArreglo(productos);
        Collections.reverse(Arrays.asList(productos)); // Otra forma de invertir el arreglo
        
        // Mostrar el arreglo invertido
        System.out.println("\nMostrando el arreglo invertido");
        mostrarArreglo(productos);
        
    }
    
    public static void invertirArreglo(String[] arreglo) {
        int total = arreglo.length;
        for (int i = 0; i < total/2; i++) {
            String actual = arreglo[i];
            String inverso = arreglo[total - i - 1];
            arreglo[i] = inverso;
            arreglo[total - i - 1] = actual;
        }
    }
    
    public static void mostrarArreglo(String[] arreglo) {
        int total = arreglo.length;
        for (int i = 0; i < total; i++) {
            System.out.println("arreglo[" + i + "] = " + arreglo[i]);
        }
    }
}
