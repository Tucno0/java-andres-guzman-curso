public class PrimitivosFloat03 {
//    static float varFlotante;
    public static void main(String[] args) {
        // Primitivos numéricos de tipo flotante
        // float
        float realFloat = 3.4028235E38F;
        System.out.println("numeroFloat = " + realFloat);
        System.out.println("tipo float corresponde en byte a " + Float.BYTES);
        System.out.println("tipo float corresponde en bites a " + Float.SIZE);
        System.out.println("valor máximo de un float " + Float.MAX_VALUE);
        System.out.println("valor  mínimo de un float " + Float.MIN_VALUE);
        
        // double
        double realDouble = 1.7976931348623157E308;
        System.out.println("\nnumeroDouble = " + realDouble);
        System.out.println("tipo double corresponde en byte a " + Double.BYTES);
        System.out.println("tipo double corresponde en bites a " + Double.SIZE);
        System.out.println("valor máximo de un double " + Double.MAX_VALUE);
        System.out.println("valor mínimo de un double " + Double.MIN_VALUE);
        
        // var
        var varFlotante = 3.4028235E38F;
        System.out.println("\nvarFlotante = " + varFlotante);
        System.out.println("tipo var corresponde en byte a " + Float.BYTES);
        System.out.println("tipo var corresponde en bites a " + Float.SIZE);
        System.out.println("valor máximo de un var " + Float.MAX_VALUE);
        System.out.println("valor mínimo de un var " + Float.MIN_VALUE);
    }
}