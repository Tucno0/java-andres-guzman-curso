public class _03_WrapperOperadoresRelacionales {
    public static void main(String[] args) {
        
        // Integer
        Integer num1 = Integer.valueOf(1000);
        Integer num2 = num1;
        
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        
        System.out.println("Son el mismo objeto?: " + (num1 == num2));
        
        num2 = 1000;
        
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        
        System.out.println("Son el mismo objeto?: " + (num1 == num2)); // false porque son objetos diferentes, contienen la misma informacion pero no la misma instancia
        
        System.out.println("Tienen el mismo valor?: " + (num1.equals(num2))); // true porque tienen el mismo valor
        System.out.println("Tienen el mismo valor?: " + (num1.intValue() == num2.intValue())); // true porque tienen el mismo valor
        
        // Boolean
        num2 = 2000;
        boolean condicion = num1 > num2; // Hace autounboxing de num1 y num2
        System.out.println("condicion = " + condicion);
        
        boolean condicion2 = num1.intValue() < num2.intValue(); // Hace unboxing de num1 y num2
        System.out.println("condicion2 = " + condicion2);
    }
}
