import java.util.Scanner;

public class _17_BuscarString {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        String[] a = new String[5];
        
        // Llenar el arreglo
        System.out.println("Ingrese 5 nombres: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print("Ingrese un nombre: ");
            a[i] = entrada.next();
        }
        
        // Buscar un número
        System.out.print("\nIngrese el número a buscar: ");
        String nombre = entrada.next();
        
        int i = 0;
        while (i < a.length && !a[i].equalsIgnoreCase(nombre)) {
            i++;
        }
        
        if (i == a.length) {
            System.out.println("El nombre " + nombre + " no se encuentra en el arreglo");
        } else if (a[i].toLowerCase().compareTo(nombre.toLowerCase()) == 0) {
            System.out.println("El nombre " + nombre + " se encuentra en la posición " + i);
        }
    }
}
