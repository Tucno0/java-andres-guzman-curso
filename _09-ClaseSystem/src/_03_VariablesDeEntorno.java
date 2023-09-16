import java.util.Map;

public class _03_VariablesDeEntorno {
    public static void main(String[] args) {
        Map<String, String> varEnv = System.getenv(); // devuelve un objeto Map con las variables de entorno
        System.out.println("Variables de entorno del sistema = " + varEnv);
        
        // Listar las variables de entorno del sistema
        for ( String key : varEnv.keySet()) {
            System.out.println(key + " => " + varEnv.get(key));
        }
        
        String username = System.getenv("USERNAME"); // devuelve el valor de la variable de entorno USERNAME
        System.out.println("\nEl nombre de usuario es " + username);
        
        String javaHome = System.getenv("JAVA_HOME"); // devuelve el valor de la variable de entorno JAVA_HOME
        System.out.println("El directorio de instalación de Java es " + javaHome);
        
        String temDir = System.getenv("TEMP"); // devuelve el valor de la variable de entorno TEMP
        System.out.println("El directorio temporal es " + temDir);
        
        String path = System.getenv("PATH"); // devuelve el valor de la variable de entorno PATH
        System.out.println("El path es " + path);
        
        String path2 = varEnv.get("Path"); // devuelve el valor de la variable de entorno Path
        System.out.println("El path es " + path2);
        
        String hola = varEnv.get("SALUDAR_HOLA");
        System.out.println("La variable de entorno SALUDAR_HOLA es " + hola);
        
        
    }
}
