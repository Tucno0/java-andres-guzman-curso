public class _13OperadorInstanceOfTiposGenericos {
    public static void main(String[] args) {
        /**
         * Object es la clase padre de todas las clases
         * Number es la clase padre de todas las clases numéricas
         */
        
        Object texto = "Creando un objeto de la clase String...";
        
        Number num = 7;
        
        Boolean b1 = texto instanceof String; // instanceof devuelve true si el objeto es del tipo indicado
        System.out.println("texto es del tipo String = " + b1);
        
        b1 = texto instanceof Object; // Object es la clase padre de todas las clases, por lo tanto, devuelve true
        System.out.println("texto es del tipo Object = " + b1);
        
        b1 = texto instanceof Integer; // texto es del tipo String, no Integer
        System.out.println("texto es del tipo Integer = " + b1);
        
        b1 = num instanceof Integer;
        System.out.println("num es del tipo Integer = " + b1);
        
        b1 = num instanceof Number; // Number es la clase padre de todas las clases numericas
        System.out.println("num es del tipo Number = " + b1);
        
        b1 = num instanceof Object;
        System.out.println("num es del tipo Object = " + b1);
        
        b1 = num instanceof Long;
        System.out.println("num es del tipo Long = " + b1);
        
        b1 = num instanceof Double;
        System.out.println("num es del tipo Double = " + b1);
        
        Double decimal = 45.54;
        b1 = decimal instanceof Double;
        System.out.println("decimal es del tipo Double = " + b1);
        
        b1 = decimal instanceof Number;
        System.out.println("decimal es del tipo Number = " + b1);
        
        b1 = b1 instanceof Boolean;
        System.out.println("b1 es del tipo Boolean = " + b1);
    }
}
