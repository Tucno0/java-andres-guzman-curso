public class NumeroMasAlto {
    public static void main(String[] args) {
        int[] numeros = {14, 33, 15, 36, 78, 21, 43};
        
        int mayor = numeros[0];
        
        for (int i = 0; i < numeros.length; i++) {
            if ( numeros[i] > mayor ) {
                mayor = numeros[i];
            }
        }
        
        System.out.println("El numero mas alto es: " + mayor);
    }
}
