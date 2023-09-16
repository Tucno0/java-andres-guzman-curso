public class _09_ArreglosOrdenPrincipioFinal {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int[] a = new int[10];
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        
        // Imprimimos el arreglo (primero : final)
        System.out.println("Imprimimos el arreglo (primero : final)");
        int aux = 0;
        for (int i = 0; i < numeros.length - i; i++) {
            System.out.print("numeros[" + i + "] = " + numeros[i] + "\t");
            a[aux++] = numeros[i];
            System.out.println("numeros[" + (numeros.length - 1 - i) + "] = " + numeros[numeros.length - 1 - i]);
            a[aux++] = numeros[numeros.length - 1 - i];
        }
        
        // Imprimimos el arreglo a
        System.out.println("\nImprimimos el arreglo a");
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
