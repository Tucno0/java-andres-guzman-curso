import java.util.Random;

public class _03_ObjetoRandom {
    public static void main(String[] args) {
        Random randomObj = new Random(); // Objeto Random para generar números aleatorios
        
        int randomInt = randomObj.nextInt(); // Devuelve un número aleatorio entre -2.147.483.648 y 2.147.483.647
        System.out.println("randomInt = " + randomInt);
        randomInt = randomObj.nextInt(10); // Devuelve un número aleatorio entre 0 y 9
        System.out.println("randomInt = " + randomInt);
        randomInt = randomObj.nextInt(10) + 1; // Devuelve un número aleatorio entre 1 y 10
        System.out.println("randomInt = " + randomInt);
        randomInt = randomObj.nextInt(30 - 20) + 20; // Devuelve un número aleatorio entre 20 y 29
        System.out.println("randomInt = " + randomInt);
        
        long randomLong = randomObj.nextLong(); // Devuelve un número aleatorio entre -9.223.372.036.854.775.808 y 9.223.372.036.854.775.807
        System.out.println("\nrandomLong = " + randomLong);
        
        String[] colores = {"azul", "amarillo", "rojo", "verde", "naranja", "violeta", "rosa"};
        int randomColor = randomObj.nextInt(colores.length); // Devuelve un número aleatorio entre 0 y 6
        System.out.println("\nrandomColor = " + randomColor);
        System.out.println("colores = " + colores[randomColor]);
    }
}
