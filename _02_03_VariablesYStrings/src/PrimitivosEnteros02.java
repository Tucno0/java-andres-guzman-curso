public class PrimitivosEnteros02 {
    
    public static void main(String[] args) {
        // Primitivos numéricos enteros
        // byte
        byte numeroByte = 127;
        System.out.println("numeroByte = " + numeroByte);
        System.out.println("tipo byte corresponde en byte a " + Byte.BYTES);
        System.out.println("tipo byte corresponde en bites a " + Byte.SIZE);
        System.out.println("valor máximo de un byte " + Byte.MAX_VALUE);
        System.out.println("valor mínimo de un byte " + Byte.MIN_VALUE);
        
        // short
        short numeroShort = 32767;
        System.out.println("\nnumeroShort = " + numeroShort);
        System.out.println("tipo short corresponde en byte a " + Short.BYTES);
        System.out.println("tipo short corresponde en bites a " + Short.SIZE);
        System.out.println("valor máximo de un short " + Short.MAX_VALUE);
        System.out.println("valor mínimo de un short " + Short.MIN_VALUE);
        
        // int
        int numeroInt = 2147483647;
        System.out.println("\nnumeroInt = " + numeroInt);
        System.out.println("tipo int corresponde en byte a " + Integer.BYTES);
        System.out.println("tipo int corresponde en bites a " + Integer.SIZE);
        System.out.println("valor máximo de un int " + Integer.MAX_VALUE);
        System.out.println("valor mínimo de un int " + Integer.MIN_VALUE);
        
        // long
        long numeroLong = 9223372036854775807L;
        System.out.println("\nnumeroLong = " + numeroLong);
        System.out.println("tipo long corresponde en byte a " + Long.BYTES);
        System.out.println("tipo long corresponde en bites a " + Long.SIZE);
        System.out.println("valor máximo de un long " + Long.MAX_VALUE);
        System.out.println("valor mínimo de un long " + Long.MIN_VALUE);
        
        // var
        var numeroVar = 127;
        System.out.println("\nnumeroVar = " + numeroVar);
        System.out.println("tipo var corresponde en byte a " + Byte.BYTES);
        System.out.println("tipo var corresponde en bites a " + Byte.SIZE);
        System.out.println("valor máximo de un var " + Byte.MAX_VALUE);
        System.out.println("valor mínimo de un var " + Byte.MIN_VALUE);
        
    }
}
