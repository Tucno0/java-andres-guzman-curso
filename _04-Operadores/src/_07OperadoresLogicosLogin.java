import java.util.Scanner;

public class _07OperadoresLogicosLogin {
    public static void main(String[] args) {
        String username = "admin";
        String password = "1234";
        
        String username2 = "juan";
        String password2 = "1234";
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su usuario: ");
        String u = scanner.next();
        
        System.out.print("Ingrese su contraseña: ");
        String p = scanner.next();
        
        boolean esAutenticado = false;
        
        if ( (username.equals(u) && password.equals(p)) || (username2.equals(u) && password2.equals(p)) ) {
            esAutenticado = true;
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }
        
        if ( esAutenticado ) {
            System.out.println("Bienvenido ".concat(u).concat("!"));
        } else {
            System.out.println("Lo sentimos, no tiene acceso al sistema");
        }
    }
}
