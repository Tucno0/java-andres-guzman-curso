public class EjemploStringMetodosArreglo17 {
    public static void main(String[] args) {
    
        // Algunos métodos útiles para convertir un String en un Arreglo de caracteres
        
        String trabalenguas = "trabalenguas";
        // toCharArray() convierte la cadena en un arreglo de caracteres
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());
        
        char[] arreglo = trabalenguas.toCharArray();
        int largo = arreglo.length;
        for (int i = 0; i < largo; i++) {
            System.out.println("arreglo[" + i + "] = " + arreglo[i]);
        }
        
        // split() convierte la cadena en un arreglo de cadenas, recibe como parámetro un caracter que indica el separador
        System.out.println("\ntrabalenguas.split(\"a\") = " + trabalenguas.split("a"));
        
        String[] arreglo2 = trabalenguas.split("a");
        largo = arreglo2.length;
        for (int i = 0; i < largo; i++) {
            System.out.println("arreglo2[" + i + "] = " + arreglo2[i]);
        }
        
        String archivo = "alguna.imagen.jpeg";
        String[] archivoArr = archivo.split("\\."); // El punto es un caracter especial, por lo que hay que escaparlo con \\
        System.out.println("\narchivoArr = " + archivoArr);
        System.out.println("Extension del archivo: " + archivoArr[archivoArr.length-1]);
    }
}
