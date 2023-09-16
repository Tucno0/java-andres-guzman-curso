import java.util.Scanner;

public class _10OperadoresLogicosLoginTernario {
    public static void main(String[] args) {
        String[] usernames = {"admin", "juan", "pedro"};
        String[] passwords = {"123", "1234", "12345"};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su usuario: ");
        String u = scanner.next();
        
        System.out.print("Ingrese su contraseña: ");
        String p = scanner.next();
        
        boolean esAutenticado = false;
        
        for (int i = 0; i < usernames.length; i++) {
            esAutenticado = (usernames[i].equals(u) && passwords[i].equals(p)) ? true : esAutenticado;
        }
        
        System.out.println(
            esAutenticado
                ? "Bienvenido ".concat(u).concat("!")
                : "Usuario o contraseña incorrectos\nLo sentimos, no tiene acceso al sistema"
        );
    }
}
