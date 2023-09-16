public class EjemploStringTestRendiminentoConcat13 {
    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = a;
        
        StringBuilder sb = new StringBuilder(a); // Lo que hace StringBuilder es crear un objeto de tipo String que es mutable
        long inicio = System.currentTimeMillis(); // Tiempo en milisegundos
        
        for ( int i = 0; i < 100000; i++) {
//            c = c.concat(a).concat(b).concat("\n"); // 500 => 2ms, 1000 => 6ms, 10000 => 121ms, 100000 => 4944ms
//            c += a + b + "\n"; // 500 => 19ms, 1000 => 24ms, 10000 => 82ms, 100000 => 2018ms
            sb.append(a).append(b).append("\n"); // 500 => 0ms, 1000 => 1ms, 10000 => 3ms, 100000 => 15ms
        }
        
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo: " + (fin - inicio));
        System.out.println("c = " + c);
        System.out.println("sb = " + sb.toString());
    }
}
