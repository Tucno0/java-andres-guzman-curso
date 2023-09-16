public class _01_ClaseMath {
    public static void main(String[] args) {
        int absoluto = Math.abs(-5); // Devuelve el valor absoluto de un número
        System.out.println("absoluto = " + absoluto);
        
        double max = Math.max(3.5, 1.2); // Devuelve el máximo entre dos números
        System.out.println("max = " + max);
        
        double min = Math.min(3.5, 1.2); // Devuelve el mínimo entre dos números
        System.out.println("min = " + min);
        
        double techo = Math.ceil(3.5); // Devuelve el entero más próximo mayor o igual que el número
        System.out.println("techo = " + techo);
        
        double piso = Math.floor(3.5); // Devuelve el entero más próximo menor o igual que el número
        System.out.println("piso = " + piso);
        
        long redondeo = Math.round(Math.PI); // Devuelve el entero más próximo del número
        System.out.println("redondeo = " + redondeo);
        
        
        double exp = Math.exp(1); // Devuelve el número e elevado a la potencia del argumento
        System.out.println("\nexp = " + exp);
        
        double log = Math.log(10); // Devuelve el logaritmo natural del argumento
        System.out.println("log = " + log);
        
        double potencia = Math.pow(10, 3); // Devuelve la potencia del primer argumento elevado al segundo argumento
        System.out.println("potencia = " + potencia);
        
        double raiz = Math.sqrt(9); // Devuelve la raíz cuadrada del argumento
        System.out.println("raiz = " + raiz);
        
        // Trigonometría
        double grados = Math.toDegrees(Math.PI); // Convierte el argumento de radianes a grados
        System.out.println("\ngrados = " + grados);
        
        double radianes = Math.toRadians(90); // Convierte el argumento de grados a radianes
        System.out.println("radianes = " + radianes);
        
        System.out.println("\nsin(90) = " + Math.sin(radianes)); // Devuelve el seno del argumento
        System.out.println("cos(90) = " + Math.cos(radianes)); // Devuelve el coseno del argumento
        
        radianes = Math.toRadians(180);
        System.out.println("cos(180) = " + Math.cos(radianes));
        radianes = Math.toRadians(0);
        System.out.println("cos(0) = " + Math.cos(radianes));
    }
}
