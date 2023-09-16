public class EjemploString10 {
    public static void main(String[] args) {
        // 002 Creando objeto String en la literal vs operador new
        String curso = "Programación Java";
        String curso2 = new String("Programación Java");
        
        boolean esIgual = curso == curso2; // compara las referencias de los objetos
        System.out.println("curso == curso2 : " + esIgual);
        esIgual = curso.equals(curso2); // compara el contenido de los objetos
        System.out.println("curso.equals(curso2) : " + esIgual);
        
        esIgual = curso.equalsIgnoreCase(curso2); // compara el contenido de los objetos ignorando mayúsculas y minúsculas
        System.out.println("curso.equalsIgnoreCase(curso2) : " + esIgual);
        
        String curso3 = "Programación Java";
        esIgual = curso == curso3;
        System.out.println("curso == curso3 : " + esIgual);
    }
}
