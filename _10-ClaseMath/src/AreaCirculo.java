import java.util.Scanner;

public class AreaCirculo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Ingrese el radio del círculo: ");
        double radio = entrada.nextDouble();
        
        double area = Math.PI * Math.pow(radio, 2);
        System.out.println("El área del círculo es: " + area);
    }
}
