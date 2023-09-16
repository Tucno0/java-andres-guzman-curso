public class _01_PasarPorValor {
    public static void main(String[] args) {
        // Pasar por valor: se crea una copia del valor de la variable y se pasa a la función o método.
        // La variable original no se modifica.
        // En Java, todos los tipos primitivos se pasan por valor.
        // Integer, Double, Float, Character, Boolean, Byte, Short, Long y String son clases inmutables.
        
        int i = 10;
        
        System.out.println("Iniciamos el método main con i = " + i);
        test(i);
        System.out.println("Finalizamos el método main con i = " + i);
    }
    
    public static void test(int i) {
        System.out.println("Iniciamos el método test con i = " + i);
        i = 35;
        System.out.println("Finalizamos el método test con i = " + i);
    }
}
