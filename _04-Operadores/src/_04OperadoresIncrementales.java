public class _04OperadoresIncrementales {
    public static void main(String[] args) {
        
        // Operadores incrementales
        int i = 1;
        
        // Pre-incremento: Primero se incrementa la variable y luego se usa su valor
        int j = ++i; // i = i + 1
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        
        // Post-incremento: Primero se asigna el valor de la variable y luego se incrementa
        i = 2;
        j = i++; // j = 2, i = 3
        System.out.println("\ni = " + i);
        System.out.println("j = " + j);
        
        // Pre-decremento: Primero se decrementa la variable y luego se usa su valor
        i = 3;
        j = --i; // i = i - 1
        System.out.println("\ni = " + i);
        System.out.println("j = " + j);
        
        // Post-decremento: Primero se asigna el valor de la variable y luego se decrementa
        i = 4;
        j = i--; // j = 4, i = 3
        System.out.println("\ni = " + i);
        System.out.println("j = " + j);
        
        System.out.println("\nj = " + (++j));
        System.out.println("j = " + (j++));
        System.out.println("j = " + j);
    }
}
