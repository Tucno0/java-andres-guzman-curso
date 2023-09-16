public class EjemploStringExtensionArchivo16 {
    public static void main(String[] args) {
        
        String archivo = "alguna.imagen.jpeg";
        System.out.println("archivo.length() = " + archivo.length());
        System.out.println("archivo.substring(14) = " + archivo.substring(14));
        
        int i = archivo.lastIndexOf('.');
        System.out.println("punto = " + i);
        System.out.println("archivo.substring(punto, archivo.length()) = " + archivo.substring(i, archivo.length()));
    }
}
