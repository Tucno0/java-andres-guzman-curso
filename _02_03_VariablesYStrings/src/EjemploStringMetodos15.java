public class EjemploStringMetodos15 {
    public static void main(String[] args) {
    
        // Métodos de la clase String
        String nombre = "Jhampier";
        
        // length() devuelve la longitud de la cadena
        System.out.println("nombre.length() = " + nombre.length());
        // toUpperCase() convierte la cadena a mayúsculas
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        // toLowerCase() convierte la cadena a minúsculas
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        // equals() compara dos cadenas y devuelve true si son iguales, compara a nivel de valor
        System.out.println("nombre.equals(\"Jhampier\") = " + nombre.equals("Jhampier"));
        System.out.println("nombre.equals(\"jhampier\") = " + nombre.equals("jhampier"));
        // equalsIgnoreCase() compara dos cadenas y devuelve true si son iguales, compara a nivel de valor ignorando mayúsculas y minúsculas
        System.out.println("nombre.equalsIgnoreCase(\"jhampier\") = " + nombre.equalsIgnoreCase("jhampier"));
        // compareTo() compara dos cadenas y devuelve 0 si son iguales, 1 si la primera es mayor que la segunda y -1 si la primera es menor que la segunda
        System.out.println("nombre.compareTo(\"Jhampier\") = " + nombre.compareTo("Jhampier"));
        System.out.println("nombre.compareTo(\"jhampier\") = " + nombre.compareTo("jhampier"));
        // charAt() devuelve el caracter de la posición indicada
        System.out.println("nombre.charAt(0) = " + nombre.charAt(0));
        System.out.println("nombre.charAt(5) = " + nombre.charAt(5));
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length()-1));
        // substring() devuelve una subcadena desde la posición indicada, la posición final es opcional y no se incluye en la subcadena
        System.out.println("nombre.substring(0) = " + nombre.substring(1));
        System.out.println("nombre.substring(1) = " + nombre.substring(1, 5));
        
        String trabalenguas = "trabalenguas";
        // replace() reemplaza un caracter por otro
        System.out.println("\ntrabalenguas.replace(\"a\", \".\") = " + trabalenguas.replace("a", "."));
        System.out.println("trabalenguas = " + trabalenguas);
        // indexOf() devuelve la posición de la primera ocurrencia de un caracter
        System.out.println("trabalenguas.indexOf('a') = " + trabalenguas.indexOf('a'));
        // lastIndexOf() devuelve la posición de la última ocurrencia de un caracter
        System.out.println("trabalenguas.lastIndexOf('a') = " + trabalenguas.lastIndexOf('a'));
        System.out.println("trabalenguas.lastIndexOf('z') = " + trabalenguas.lastIndexOf('z')); // -1 si no encuentra el caracter
        // contains() devuelve true si la cadena contiene el caracter indicado
        System.out.println("trabalenguas.contains(\"t\") = " + trabalenguas.contains("t"));
        System.out.println("trabalenguas.contains(\"z\") = " + trabalenguas.contains("z"));
        System.out.println("trabalenguas.contains(\"lenguas\") = " + trabalenguas.contains("lenguas"));
        // startsWith() devuelve true si la cadena empieza con el caracter indicado
        System.out.println("trabalenguas.startsWith(\"tr\") = " + trabalenguas.startsWith("tr"));
        System.out.println("trabalenguas.startsWith(\"t\") = " + trabalenguas.startsWith("t"));
        System.out.println("trabalenguas.startsWith(\"z\") = " + trabalenguas.startsWith("z"));
        // endsWith() devuelve true si la cadena termina con el caracter indicado
        System.out.println("trabalenguas.endsWith(\"s\") = " + trabalenguas.endsWith("s"));
        System.out.println("trabalenguas.endsWith(\"z\") = " + trabalenguas.endsWith("z"));
        // trim() elimina los espacios al inicio y al final de la cadena
        String trabalenguas2 = "   trabalenguas   ";
        System.out.println("\ntrabalenguas2.trim() = " + trabalenguas2.trim());
    }
}
