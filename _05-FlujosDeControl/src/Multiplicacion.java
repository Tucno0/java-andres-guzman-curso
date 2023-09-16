import java.util.Scanner;

public class Multiplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el primer numero: ");
        int numero1 = scanner.nextInt();
        System.out.print("Ingrese el Segundo numero: ");
        int numero2 = scanner.nextInt();
        
        int resultado = 0;
        
        if ( numero1 == 0 || numero2 == 0) {
            resultado = 0;
        } else {
            if ( numero1 < 0 ) {
                if ( numero2 < 0) {
                    numero1*=-1;
                    numero2*=-1;
                    for (int i = 1; i<=numero1; i++) {
                        resultado += numero2;
                    }
                } else {
                    for (int i = 1; i <= numero2; i++) {
                        resultado += numero1;
                    }
                }
            } else {
                if ( numero2 > 0) {
                    for (int i = 1; i<=numero2; i++) {
                        resultado+=numero1;
                    }
                } else {
                    for ( int i = 1; i <= numero1; i++) {
                        resultado+=numero2;
                    }
                }
            }
        }
        
        System.out.println("resultado = " + resultado);
    }
}
