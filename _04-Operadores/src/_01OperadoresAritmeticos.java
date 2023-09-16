public class _01OperadoresAritmeticos {
    public static void main(String[] args) {
        // Operadores aritméticos
        int i = 5, j = 4;
        System.out.println("i = " + i + ", j = " + j);
        
        // Suma ( + )
        int suma = i + j;
        System.out.println("\nsuma = " + suma);
        System.out.println("i + j = " + (i + j));
        
        // Resta ( - )
        int resta = i - j;
        System.out.println("\nresta = " + resta);
        System.out.println("i - j = " + (i - j));
        
        // Multiplicación ( * )
        int multiplicacion = i * j;
        System.out.println("\nmultiplicacion = " + multiplicacion);
        System.out.println("i * j = " + (i * j));
        
        // División ( / )
        double division = (double) i / j; // Se hace un cast a double para que el resultado sea double
        System.out.println("\ndivision = " + division);
        System.out.println("i / j = " + ((double) i / j));
        
        // Módulo o residuo ( % )
        int resto = i % j;
        System.out.println("\nmodulo = " + resto);
        System.out.println("i % j = " + (i % j));
    }
}
