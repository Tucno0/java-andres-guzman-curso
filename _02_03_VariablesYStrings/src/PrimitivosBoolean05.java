public class PrimitivosBoolean05 {
    public static void main(String[] args) {
        // Primitivos boolean
        boolean datoLogico = true;
        System.out.println("datoLogico = " + datoLogico);
        
        // Objeto Boolean
        boolean datoLogico2 = Boolean.TRUE;
        System.out.println("datoLogico2 = " + datoLogico2);
        
        Boolean datoLogico3 = true;
        System.out.println("datoLogico3 = " + datoLogico3);
        
        // Ejemplos
        double d = 98765.43e-3; // 98.76543
        System.out.println("d = " + d);
        float f = 1.2345e2f; // 123.45
        System.out.println("f = " + f);
        
        datoLogico = d > f;
        System.out.println("datoLogico = " + datoLogico);
        
        boolean esIgual = 3 - 2 == 1;
        System.out.println("esIgual = " + esIgual);
        
    }
}
