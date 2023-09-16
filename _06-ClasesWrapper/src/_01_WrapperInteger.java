public class _01_WrapperInteger {
    public static void main(String[] args) {
        int intPrimitivo = 32768; // Tipo primitivo int
        
        // Wrapper Integer
        // Convierte un tipo primitivo int a un objeto Integer
        Integer intObjeto = Integer.valueOf(32768); // valueOf() retorna um objeto Integer
        Integer intObjeto2 = 32768; // autoboxing
        Integer intObjeto3 = Integer.valueOf(intPrimitivo);
        System.out.println("intObjeto = " + intObjeto);
        
        // Convierte un objeto Integer a un tipo primitivo int
        int num = intObjeto;
        System.out.println("\nnum = " + num);
        int num2 = intObjeto.intValue(); // intValue() retorna un tipo primitivo int de un objeto Integer
        System.out.println("num2 = " + num2);
        
        // Convierte un String a un tipo primitivo int
        String valorTvLcd = "67000";
        Integer valor = Integer.valueOf(valorTvLcd); // Convierte un String a un objeto Integer
        System.out.println("\nvalor = " + valor);
        
        // Short Wrapper
        Short shortObjeto = 32767;
        System.out.println("\nshortObjeto = " + shortObjeto);
        Short shortObjeto2 = intObjeto.shortValue(); // shortValue() retorna un tipo primitivo short de un objeto Integer
        System.out.println("shortObjeto2 = " + shortObjeto2);
        
        // Byte Wrapper
        Byte byteObjeto = 127;
        System.out.println("\nbyteObjeto = " + byteObjeto);
        Byte byteObjeto2 = intObjeto.byteValue(); // byteValue() retorna un tipo primitivo byte de un objeto Integer
        System.out.println("byteObjeto2 = " + byteObjeto2);
        
        // Long Wrapper
        Long longObjeto = 2147483648L;
        System.out.println("\nlongObjeto = " + longObjeto);
        Long longObjeto2 = intObjeto.longValue(); // longValue() retorna un tipo primitivo long de un objeto Integer
        System.out.println("longObjeto2 = " + longObjeto2);
    }
}
