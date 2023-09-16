public class _02_AutoboxingInteger {
    public static void main(String[] args) {
        Integer[] enteros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; // Autoboxing
        
        int sumaPares = 0;
        
        for (Integer entero : enteros) {
            if (entero.intValue() % 2 == 0) {
                sumaPares += entero.intValue(); // Autounboxing
            }
        }
        
        System.out.println("sumaPares = " + sumaPares);
        
        sumaPares = 0;
        
        for (Integer entero : enteros) {
            if (entero % 2 == 0) {
                sumaPares += entero; // Autounboxing
            }
        }
        
        System.out.println("sumaPares = " + sumaPares);
    }
}
