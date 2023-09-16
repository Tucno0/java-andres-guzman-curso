public class _06SentenciaFor {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.printf("El valor de i es: %d\n", i);
        }
        System.out.println("-------------");
        for (int i = 10; i > 0; i--) {
            System.out.printf("El valor de i es: %d\n", i);
        }
        System.out.println("-------------");
        for ( int i = 1, j = 10; i < j; i++, j--) {
            System.out.printf("El valor de i es: %d y el valor de j es: %d\n", i, j);
        }
        System.out.println("-------------");
        for ( int i = 0; i < 10; i++) {
            if (i%2 == 0) {
                continue;
            }
            System.out.printf("El valor de i impar es: %d\n", i);
        }
    }
}
