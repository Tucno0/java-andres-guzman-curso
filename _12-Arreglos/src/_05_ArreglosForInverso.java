import java.lang.reflect.Array;
import java.util.Arrays;

public class _05_ArreglosForInverso {
    public static void main(String[] args) {
        int[] numeros = new int[7];
        int total = numeros.length;
        
        // Llenando el arreglo con un for
        for (int i = 0; i< total; i++) {
            numeros[i] = i*3;
        }
        
        // Mostrando los elementos del arreglo con un for inverso primera forma
        System.out.println("\nMostrando los elementos del arreglo con un for inverso primera forma");
        for (int i = 0; i< total; i++) {
            System.out.println("numeros[" + (total - i - 1) + "] = " + numeros[total - i - 1]);
        }
        
        // Mostrando los elementos del arreglo con un for inverso segunda forma
        System.out.println("\nMostrando los elementos del arreglo con un for inverso segunda forma");
        for (int i = total-1; i >= 0; i--) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }
        
        String[] productos = {"Kingston Pendrive 64GB", "Samsung Galaxy", "Disco Duro SSD Samsung Externo", "Asus Notebook", "MacBook Air", "Chromecast 4ta Generación", "Bicicleta Oxford"};
        int totalProductos = productos.length;
        
        Arrays.sort(productos);
        
        // Mostrando los elementos del arreglo con un for inverso primera forma
        System.out.println("\nMostrando los elementos del arreglo con un for inverso primera forma");
        for (int i = 0; i< totalProductos; i++) {
            System.out.println("productos[" + (totalProductos - i - 1) + "] = " + productos[totalProductos - i - 1]);
        }
        
        // Mostrando los elementos del arreglo con un for inverso segunda forma
        System.out.println("\nMostrando los elementos del arreglo con un for inverso segunda forma");
        for (int i = totalProductos-1; i >= 0; i--) {
            System.out.println("productos[" + i + "] = " + productos[i]);
        }
    }
}
