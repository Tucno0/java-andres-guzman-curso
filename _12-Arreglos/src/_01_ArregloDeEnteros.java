public class _01_ArregloDeEnteros {
    public static void main(String[] args) {
        int[] numeros = new int[4];
        
        numeros[0] = 10;
        numeros[1] = Integer.valueOf("20");
        numeros[2] = (int) 30L;
        numeros[3] = 40;
        // numeros[4] = 50; // Error en tiempo de ejecución (ArrayIndexOutOfBoundsException)
        
        int i = numeros[0];
        int j = numeros[1];
        int k = numeros[2];
        int l = numeros[numeros.length - 1]; // Ultimo elemento del arreglo
        
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
        System.out.println("l = " + l);
    }
}
