public class _05OperadoresRelacionales {
    public static void main(String[] args) {
        // Operadores relacionales
        int i = 3;
        int j = 7;
        float k = 127e-7f;
        double l = 2.1413e3;
        boolean m = false;
        
        // Igualdad ( == )
        boolean b1 = i == j;
        System.out.println("b1 = " + b1);
        
        boolean b2 = !b1;
        System.out.println("b2 = " + b2);
        
        // Desigualdad ( != )
        boolean b3 = i != j;
        System.out.println("b3 = " + b3);
        
        boolean b4 = m == true;
        System.out.println("b4 = " + b4);
        boolean b5 = m != true;
        System.out.println("b5 = " + b5);
        
        // Mayor que ( > )
        boolean b6 = i > j;
        System.out.println("b6 = " + b6);
        
        // Menor que ( < )
        boolean b7 = i < j;
        System.out.println("b7 = " + b7);
        
        // Mayor o igual que ( >= )
        boolean b8 = l >= k;
        System.out.println("b8 = " + b8);
        
        // Menor o igual que ( <= )
        boolean b9 = l <= k;
        System.out.println("b9 = " + b9);
    }
}
