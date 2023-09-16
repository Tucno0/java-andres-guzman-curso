import java.util.Scanner;

public class TareaProgramaManejoDeNombres18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese nombre 1: ");
        String nombre1 = scanner.nextLine();
        nombre1 = nombre1.substring(1,2).toUpperCase() + "." + nombre1.substring(nombre1.length() - 2);
        
        System.out.print("Ingrese nombre 2: ");
        String nombre2 = scanner.nextLine();
        nombre2 = nombre2.substring(1,2).toUpperCase() + "." + nombre2.substring(nombre2.length() - 2);

        System.out.print("Ingrese nombre 3: ");
        String nombre3 = scanner.nextLine();
        nombre3 = nombre3.substring(1,2).toUpperCase() + "." + nombre3.substring(nombre3.length() - 2);
        
        System.out.println("nombre1 = " + nombre1);
        System.out.println("nombre1 = " + nombre2);
        System.out.println("nombre1 = " + nombre3);
        
        String nombres = nombre1 + "_" + nombre2 + "_" + nombre3;
        System.out.println("nombres = " + nombres);
    }
}
