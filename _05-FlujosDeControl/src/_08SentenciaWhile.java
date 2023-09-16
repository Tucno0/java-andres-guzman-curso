public class _08SentenciaWhile {
    public static void main(String[] args) {
        int i = 0;
        
        // sentencia while
        while (i < 5) {
            System.out.println("i = " + i);
            i++;
        }
        
        System.out.println();
        i = 0;
        boolean prueba = true;
        while (prueba) {
            if (i == 7) {
                prueba = false;
            }
            System.out.println("i = " + i);
            i++;
        }
        
        System.out.println();
        prueba = false;
        while (prueba) {
            System.out.println("Esto no se va a ejecutar");
        }
        
        // sentencia do while
        do {
            System.out.println("Se ejecuta al menos una vez\n");
        } while (prueba);
        
        i = 0;
        prueba = true;
        do {
            if (i == 7) {
                prueba = false;
            }
            System.out.println("i = " + i);
            i++;
        } while (prueba);
    }
}