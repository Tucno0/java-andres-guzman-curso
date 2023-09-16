public class _11_Combinar2ArreglosConMultiplesElementos {
    public static void main(String[] args) {
        int[] a, b, c;
        a = new int[10];
        b = new int[10];
        c = new int[20];
        
        // Llenamos los arreglos a y b
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        
        for (int i = 0; i < b.length; i++) {
            b[i] = (i + 1) * 5;
        }
        
        // Imprimimos los arreglos a y b
        System.out.println("Imprimimos los arreglos a y b");
        imprimir(a);
        imprimir(b);
        
        // Combinamos los arreglos a y b en el arreglo c
        int aux = 0;
        for (int i = 0; i < a.length; i+=2) {
            for (int j = 0; j < 2; j++) {
                c[aux++] = a[i+j];
            }
            for (int j = 0; j < 2; j++) {
                c[aux++] = b[i+j];
            }
        }
        
        // Imprimimos el arreglo c
        System.out.println("Imprimimos el arreglo c");
        imprimir(c);
    }
    
    public static void imprimir(int[] arreglo) {
        int total = arreglo.length;
        
        for (int i = 0; i < total; i++) {
            System.out.println("Para indice " + i + " : " + arreglo[i]);
        }
        
        System.out.println("");
    }
}
