import java.lang.reflect.Method;

public class _05_EjemploMetodoGetClass {
    public static void main(String[] args) {
        String texto = "Hola que tal";
        Class strClass = texto.getClass(); // Class es una clase de Java que representa la clase String
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
        System.out.println("strClass = " + strClass);
        System.out.println("");
        
        for (Method metodo : strClass.getMethods()) { // getMethods() devuelve un array de objetos Method
            System.out.println("metodo.getName() = " + metodo.getName());
        }
        
        Integer num = 34;
        Class intClass = num.getClass();
        Class objClass = intClass.getSuperclass().getSuperclass();
        System.out.println("\nintClass.getName() = " + intClass.getName());
        System.out.println("intClass.getSimpleName() = " + intClass.getSimpleName());
        System.out.println("intClass.getPackageName() = " + intClass.getPackageName());
        System.out.println("intClass = " + intClass);
        System.out.println("intClass.getSuperclass().getSuperclass() = " + intClass.getSuperclass());
        System.out.println("intClass.getSuperclass().getSuperclass() = " + objClass);
        System.out.println("");
        
        for (Method metodo : objClass.getMethods()) {
            System.out.println("metodo.getName() = " + metodo.getName());
        }
    }
}