import java.util.Scanner;

public class _15TareaMayorMenor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num1, num2;
        
        System.out.print("Ingrese el primer número: ");
        num1 = scanner.nextInt();
        
        System.out.print("Ingrese el segundo número: ");
        num2 = scanner.nextInt();
        
        String mensaje = num1 > num2
            ? "De mayor a menor: " + num1 + "->" + num2
            : "De mayor a menor: " + num2 + "->" + num1;
        
        System.out.println(mensaje);
    }
}
