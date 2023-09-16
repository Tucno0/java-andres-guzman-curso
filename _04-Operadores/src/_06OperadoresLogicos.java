public class _06OperadoresLogicos {
    public static void main(String[] args) {
        // Operadores lógicos
        int i = 3;
        int j = 3;
        float k = 127e-7f;
        double l = 2.1413e3;
        boolean m = false;
        
            // Operador AND ( && )
            boolean b1 = i == j && k < l && m == false;
            System.out.println("b1 = " + b1);
            
            // Operador OR ( || )
            boolean b2 = i == j || k < l;
            System.out.println("b2 = " + b2);
            
            // Operador NOT ( ! )
            boolean b3 = !(i > j);
            System.out.println("b3 = " + b3);

            // Operador AND ( && ) y OR ( || )
            boolean b4 = i > j && k < l || m == true; // && tiene prioridad sobre ||
            System.out.println("b4 = " + b4);

            boolean b5 = i > j && (k < l || m == true);
            System.out.println("b5 = " + b5);

            boolean b6 = (i > j && k < l) || m == true;
            System.out.println("b6 = " + b6);

            boolean b7 = (i > j && k < l) || (m == true);
            System.out.println("b7 = " + b7);

            boolean b8 = (i > j && k < l) || !(m == true);
            System.out.println("b8 = " + b8);

            boolean b9 = (i > j && k < l) || !(m == true) && i < j;
            System.out.println("b9 = " + b9);

            boolean b10 = (i > j && k < l) || (!(m == true) && i < j);
            System.out.println("b10 = " + b10);

            boolean b11 = (i > j && k < l) || (!(m == true) && (i < j));
            System.out.println("b11 = " + b11);

            boolean b12 = (i > j && k < l) || (!(m == true) && !(i < j));
            System.out.println("b12 = " + b12);

            boolean b13 = (i > j && k < l) || (!(m == true) && !(i < j) && i < j);
            System.out.println("b13 = " + b13);
            
            
    }
}
