public class _02_PasarPorReferencia {
    public static void main(String[] args) {
        // Pasar por referencia es pasar la dirección de memoria de un objeto o variable
        // a un método, de tal forma que si el método modifica el objeto o variable,
        // el cambio se refleja en el método llamador.
        
        int[] edad = {10, 11, 12};
        
        System.out.println("Iniciamos el método main");
        
        for (int i : edad) {
            System.out.println("i = " + i);
        }
        
        System.out.println("Antes de llamar al método test");
        test(edad);
        System.out.println("Después de llamar al método test");
        
        for (int i : edad) {
            System.out.println("i = " + i);
        }
        
        System.out.println("Finalizamos el método main con los datos del arreglo modificados!");
    }
    
    public static void test(int[] edadArr) {
        System.out.println("Iniciamos el método test con i");
        
        for (int i = 0; i < edadArr.length; i++) {
            edadArr[i] += 20;
        }
        
        System.out.println("Finalizamos el método test con i");
    }
}
