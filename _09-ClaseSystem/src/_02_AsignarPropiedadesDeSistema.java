import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class _02_AsignarPropiedadesDeSistema {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            FileInputStream archivo = new FileInputStream("src/config.properties");
            
            Properties p = new Properties(System.getProperties()); // carga las propiedades del sistema
            p.load(archivo); // aquí se cargan las propiedades del archivo config.properties
            p.setProperty("mi.propiedad.personalizada", "mi valor personalizado"); // se añade una propiedad personalizada
            System.setProperties(p); // se asignan las propiedades al sistema
            
            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada")); // se muestra la propiedad personalizada
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));
            System.out.println();
            
            System.getProperties().list(System.out); // se muestran las propiedades del sistema
            
        } catch (Exception e) {
            System.err.println("No se ha encontrado el archivo " + e); // err es para mostrar el mensaje en rojo
            System.exit(1); // 1: error, 0: todo bien, otro número: otro error
        }
        
        //System.gc();
        // se ejecuta el recolector de basura (garbage collector)
        // se puede ejecutar con System.gc() o Runtime.getRuntime().gc()
        // pero no se puede forzar su ejecución
        // Sirve para liberar memoria
    }
}
