import java.util.Properties;

public class _01_EjemploPropiedadesDelSystema {
    public static void main(String[] args) {
        String username = System.getProperty("user.name");
        System.out.println("Hola " + username);
        
        String home = System.getProperty("user.home");
        System.out.println("Tu directorio de usuario es " + home);
        
        String workspace = System.getProperty("user.dir");
        System.out.println("Tu directorio de trabajo es " + workspace);
        
        String java = System.getProperty("java.home");
        System.out.println("Tu directorio de instalación de Java es " + java);
        
        String javaVersion = System.getProperty("java.version");
        System.out.println("Tu versión de Java es " + javaVersion);
        
        String os = System.getProperty("os.name");
        System.out.println("Tu sistema operativo es " + os);
        
        String osVersion = System.getProperty("os.version");
        System.out.println("Tu versión de sistema operativo es " + osVersion);
        
        String osArch = System.getProperty("os.arch");
        System.out.println("Tu arquitectura de sistema operativo es " + osArch);
        
        String javaVendor = System.getProperty("java.vendor");
        System.out.println("Tu proveedor de Java es " + javaVendor);
        
        String javaVendorUrl = System.getProperty("java.vendor.url");
        System.out.println("La URL de tu proveedor de Java es " + javaVendorUrl);
        
        String javaClassPath = System.getProperty("java.class.path");
        System.out.println("Tu classpath de Java es " + javaClassPath);
        
        String fileSeparator = System.getProperty("file.separator");
        System.out.println("Tu separador de ficheros es " + fileSeparator);
        
        String lineSeparator = System.getProperty("line.separator");
        System.out.println("Tu separador de líneas es " + lineSeparator);
        
        // Listar las configuraciones completas de todas las propiedades del sistema
        Properties p = System.getProperties(); // System.getProperties() devuelve un objeto Properties
        p.list(System.out); // System.out es un objeto PrintStream que representa la salida estándar
    }
}
