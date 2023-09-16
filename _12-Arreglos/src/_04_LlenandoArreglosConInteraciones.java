public class _04_LlenandoArreglosConInteraciones {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int total = numeros.length;
        
        // Llenando el arreglo con un for
        for (int i = 0; i< total; i++) {
            numeros[i] = i*3;
        }
        
        // Mostrando los elementos del arreglo con un for
        System.out.println("\nMostrando los elementos del arreglo con un for");
        for (int i = 0; i< total; i++) {
            System.out.println("numeros[" + i + "] = " + numeros[i]);
        }
    }
}
