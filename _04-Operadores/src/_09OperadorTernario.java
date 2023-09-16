import java.util.Scanner;

public class _09OperadorTernario {
    public static void main(String[] args) {
        
        /**
         * Operador ternario
         * variable = (condición) ? valor1 : valor2;
         * Si la condición es verdadera, se asigna valor1 a la variable
         * Si la condición es falsa, se asigna valor2 a la variable
         */
        
        String variable = 7 == 7 ? "Sí, es igual" : "No, no es igual";
        System.out.println("variable = " + variable);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\n\nIngrese la nota de matemáticas en el rango de 0 a 10.0: ");
        double matematicas = scanner.nextDouble();
        System.out.print("Ingrese la nota de ciencias en el rango de 0 a 10.0: ");
        double ciencias = scanner.nextDouble();
        System.out.print("Ingrese la nota de historia en el rango de 0 a 10.0: ");
        double historia = scanner.nextDouble();
        
        double promedio = (matematicas + ciencias + historia) / 3;
        System.out.println("promedio = " + promedio);
        
        String estado = promedio >= 5.49 ? "Aprobado" : "Reprobado";
        System.out.println("estado = " + estado);
        
    }
}
