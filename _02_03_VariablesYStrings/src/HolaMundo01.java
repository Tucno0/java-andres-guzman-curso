public class HolaMundo01 {
    public static void main(String[] args) {
        
        // Tipos de datos en Java
        // String
        String saludar = "Hola Mundo desde Java";
        System.out.println(saludar);
        System.out.println("saludar.toUpperCase() = " + saludar.toUpperCase());
        
        // Integer:  Clase que envuelve al tipo primitivo int, le añada funcionalidades
        Integer numero = 10;
        System.out.println("numero = " + numero);
        
        // Tipos primitivos
        // int
        int numero2 = 10;
        System.out.println("numero2 = " + numero2);
        
        // boolean
        boolean valor = true;
        if (valor) {
            System.out.println("valor = " + valor);
            numero2 = 20;
        }
        
        System.out.println("numero2 = " + numero2);
        
        // Tipado dinámico
        var numero3 = 15;
        
        // Reglas para definir una variable
        String nombre;
        nombre = "Andrés";
        
        if (numero > 10) {
            nombre = "Juan";
        }
        
        System.out.println("nombre = " + nombre);
        
        
    }
}
