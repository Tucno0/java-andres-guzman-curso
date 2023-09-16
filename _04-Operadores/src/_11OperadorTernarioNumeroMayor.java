import java.util.Scanner;

public class _11OperadorTernarioNumeroMayor {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int numero1, numero2, numero3, numeroMayor;
        System.out.print("Ingrese el primer número: ");
        numero1 = scanner.nextInt();
        System.out.print("Ingrese el segundo número: ");
        numero2 = scanner.nextInt();
        System.out.print("Ingrese el tercer número: ");
        numero3 = scanner.nextInt();
        
        numeroMayor = (numero1 > numero2) ? numero1 : numero2;
        numeroMayor = (numero3 > numeroMayor) ? numero3 : numeroMayor;
        
        System.out.println("El número mayor es: " + numeroMayor);
    }
}
