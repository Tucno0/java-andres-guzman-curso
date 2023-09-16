public class ConversionDeTipos08 {
    public static void main(String[] args) {
        // Conversion de cadenas a tipos primitivos
        // Convertir un String a un tipo int
        String numeroStr = "50";
        int numeroInt = Integer.parseInt(numeroStr);
        System.out.println("numeroInt = " + numeroInt);
        
        // Convertir un String a un tipo double
        String realStr = "98765.43e-3";
        double realDouble = Double.parseDouble(realStr);
        System.out.println("realDouble = " + realDouble);
        
        // Convertir un String a un tipo boolean
        String logicoStr = "true"; // false = "false", False, numéricos, letras , True = "True", "TRUE", "tRUE", "TrUe"
        boolean logicoBoolean = Boolean.parseBoolean(logicoStr);
        System.out.println("logicoBoolean = " + logicoBoolean);
        
        // Conversion de tipos primitivos a cadenas
        // Convertir un tipo int a String
        int otroNumeroInt = 100;
        System.out.println("otroNumeroInt = " + otroNumeroInt);
        String otroNumeroStr = Integer.toString(otroNumeroInt);
        System.out.println("otroNumeroStr = " + otroNumeroStr);
        otroNumeroStr = String.valueOf(otroNumeroInt);
        System.out.println("otroNumeroStr = " + otroNumeroStr + 10);
        
        // Convertir un tipo double a String
        double otroRealDouble = 1.23456e2;
        String otroRealStr = Double.toString(otroRealDouble);
        System.out.println("otroRealStr = " + otroRealStr);
        otroRealStr = String.valueOf(1.23456f);
        System.out.println("otroRealStr = " + otroRealStr);
        
        // Convertir entre tipos primtivos
        // Convertir un tipo int a tipo short
//        int i = 1000;
        int i = 428778; // El valor 428778 no cabe en un tipo short, por lo que se pierde información
        short s = (short) i; // Casting, forzamos la conversión de un tipo a otro porque short es más pequeño que int
        System.out.println("s = " + s);
        long l = i; // No es necesario el casting porque long es más grande que int
        System.out.println("l = " + l);
        
        char b = (char) i;
        System.out.println("b = " + b);
        
        float f = (float) i;
        System.out.println("f = " + f);
        
    }
}
