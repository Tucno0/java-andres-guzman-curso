public class PrimitivosCaracteres04 {
    public static void main(String[] args) {
        // char
        char miCaracter = 'a';
        System.out.println("miCaracter = " + miCaracter);
        
        char caracterUnicode = '\u0040';
        System.out.println("caraterUnicode = " + caracterUnicode);
        
        char caracterDecimal = 64;
        System.out.println("caracterDecimal = " + caracterDecimal);
        System.out.println("caracterDecimal = caraterUnicode : " + (caracterDecimal == caracterUnicode));
        
        char caracterSimbolo = '@';
        System.out.println("simbolo = " + caracterSimbolo);
        System.out.println("(caracterSimbolo == caraterUnicode) = " + (caracterSimbolo == caracterUnicode));
        
        System.out.println("char correspondiente en byte = " + Character.BYTES);
        System.out.println("char correspondiente en bites = " + Character.SIZE);
        System.out.println("valor mínimo de un char = " + Character.MIN_VALUE);
        System.out.println("valor máximo de un char = " + Character.MAX_VALUE);
        
        // var
        var varChar = '\u0021';
        System.out.println("varChar = " + varChar);
        
        // caracteres especiales
        char espacio = ' ';
        char espacioUnicode = '\u0020';
        char retroceso = '\b';
        char tabulador = '\t';
        char nuevaLinea = '\n';
        char retornoCarro = '\r';
        
        System.out.println("Hola a todos" + espacio + "que tal" + espacioUnicode + "están" + nuevaLinea + " @" + retroceso + "bien" + tabulador + "y" + espacio + "ustedes");
    }
}
