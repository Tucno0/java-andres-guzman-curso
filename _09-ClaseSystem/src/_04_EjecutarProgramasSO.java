import java.io.IOException;

public class _04_EjecutarProgramasSO {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime(); // Sirve para ejecutar programas del sistema operativo
        Process proceso;
        
        try {
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
                proceso = rt.exec("notepad");
            } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")) {
                proceso = rt.exec("textedit");
            } else if (System.getProperty("os.name").toLowerCase().contains("nux") ||
                    System.getProperty("os.name").toLowerCase().contains("nix")) {
                proceso = rt.exec("gedit");
            } else {
                proceso = rt.exec("gedit");
            }
            proceso.waitFor(); // espera a que termine el proceso
            
        } catch (Exception e) {
            System.err.println("El comando es desconocido" + e.getMessage()); // err es para mostrar el mensaje en rojo
            System.exit(1); // 1: error, 0: todo bien, otro número: otro error
        }
        
        System.out.println("El comando se ha ejecutado correctamente");
        System.exit(0);
    }
}
