public class _09SentenciaForEach {
    public static void main(String[] args) {
        /**
         * Sentencia for each
         * Es una forma especial de la sentencia for que nos permite recorrer los elementos de un array o una colección
         * de una forma más sencilla. Se utiliza cuando no necesitamos conocer el índice de cada elemento.
         */
        
        int[] numeros = {1, 3, 5, 7, 9, 11, 13, 14};
        for (int num : numeros) {
            System.out.println("num = " + num);
        }
        
        System.out.println();
        
        String[] nombres = {"Andres", "Pepe", "Maria", "Paco", "Lalo", "Bea", "Pato", "Pepa"};
        for (String nombre : nombres) {
            System.out.println("nombre = " + nombre);
        }
        
    }
}
