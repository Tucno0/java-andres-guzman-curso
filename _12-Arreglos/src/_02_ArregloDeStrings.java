import java.util.Arrays;

public class _02_ArregloDeStrings {
    public static void main(String[] args) {
        String[] productos = new String[7];
        
        // Por defecto, los elementos de un arreglo de Strings son null
    
        productos[0] = "Kingston Pendrive 64GB";
        productos[1] = "Samsung Galaxy";
        productos[2] = "Disco Duro SSD Samsung Externo";
        productos[3] = "Asus Notebook";
        productos[4] = "MacBook Air";
        productos[5] = "Chromecast 4ta Generación";
        productos[6] = "Bicicleta Oxford";
        
        // Ordena los elementos del arreglo
        Arrays.sort(productos);
        
        // Accediendo a los elementos del arreglo
        String producto1 = productos[0];
        String producto2 = productos[1];
        String producto3 = productos[2];
        String producto4 = productos[3];
        String producto5 = productos[4];
        String producto6 = productos[5];
        String producto7 = productos[6];
        
        System.out.println("productos[0] = " + producto1);
        System.out.println("productos[1] = " + producto2);
        System.out.println("productos[2] = " + producto3);
        System.out.println("productos[3] = " + producto4);
        System.out.println("productos[4] = " + producto5);
        System.out.println("productos[5] = " + producto6);
        System.out.println("productos[6] = " + producto7);
        
    }
}
