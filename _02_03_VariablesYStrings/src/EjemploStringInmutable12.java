public class EjemploStringInmutable12 {
    public static void main(String[] args) {
        // 003 Concatenando String
        String curso = "Programación Java";
        String profesor = "Andrés Guzmán";
        
        String resultado = curso.concat(profesor);
        System.out.println("curso = " + curso);
        System.out.println("resultado = " + resultado);
        System.out.println(curso == resultado);
        
        String resultado2 = curso.transform(c -> { // Transforma el String curso
            System.out.println("\nc = " + c);
            System.out.println("c.length() = " + c.length());
            return c + " con " + profesor;
        });
        System.out.println("curso = " + curso);
        System.out.println("resultado2 = " + resultado2);
        
        String resultado3 = resultado.replace("a", "A");
        System.out.println("\nresultado = " + resultado);
        System.out.println("resultado3 = " + resultado3);
    }
}
