public class _04_WrapperBoolean {
    public static void main(String[] args) {
        Integer num1, num2;
        num1 = 1;
        num2 = 2;
        
        boolean primBoolean = num1 > num2; // false
        Boolean objBoolean = Boolean.valueOf(primBoolean); // false
        Boolean objBoolean2 = Boolean.valueOf("false");
        Boolean objBoolean3 = true;
        
        System.out.println("primBoolean = " + primBoolean);
        System.out.println("objBoolean = " + objBoolean);
        System.out.println("objBoolean2 = " + objBoolean2);
        
        System.out.println("\nComparando dos objetos Boolean: " + (objBoolean == objBoolean2));
        System.out.println("Comparando dos objetos Boolean: " + (objBoolean.equals(objBoolean2)));
        System.out.println("Comparando dos objetos Boolean: " + (objBoolean2 == objBoolean3));
        System.out.println("Comparando dos objetos Boolean: " + (objBoolean == objBoolean3));
        
        boolean primBoolean2 = objBoolean2.booleanValue(); // retorna un tipo primitivo boolean de un objeto Boolean
        System.out.println("\nprimBoolean2 = " + primBoolean2);
    }
}
