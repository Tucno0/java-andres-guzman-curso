public class _02_ClaseMathRandom {
    public static void main(String[] args) {
        String[] colores = {"azul", "amarillo", "rojo", "verde", "naranja", "violeta", "rosa"};
        
        double random = Math.random(); // Devuelve un número aleatorio entre 0.0 y 1.0
        System.out.println("random = " + random);
        
        random *= Math.random() * colores.length; // Devuelve un número aleatorio entre 0.0 y 6.0
        System.out.println("random = " + random);
        
        random = Math.floor(random); // Devuelve un número aleatorio entre 0.0 y 6.0
        System.out.println("random = " + random);
        
        System.out.println("colores = " + colores[(int) random]);
    }
}
