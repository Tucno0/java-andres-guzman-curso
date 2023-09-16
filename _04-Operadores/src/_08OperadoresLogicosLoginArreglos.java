import java.util.Scanner;

public class _08OperadoresLogicosLoginArreglos {
    public static void main(String[] args) {
        
        /*String[] usernames = new String[3];
        usernames[0] = "admin";
        usernames[1] = "juan";
        usernames[2] = "pedro";
        
        String[] passwords = new String[3];
        passwords[0] = "1234";
        passwords[1] = "1234";
        passwords[2] = "1234";*/
        
        String[] usernames = {"admin", "juan", "pedro"};
        String[] passwords = {"123", "1234", "12345"};
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su usuario: ");
        String u = scanner.next();
        
        System.out.print("Ingrese su contraseña: ");
        String p = scanner.next();
        
        boolean esAutenticado = false;
        
        for (int i = 0; i < usernames.length; i++) {
            if ( (usernames[i].equals(u) && passwords[i].equals(p)) ) {
                esAutenticado = true;
                break;
            }
        }
        
        if ( esAutenticado ) {
            System.out.println("Bienvenido ".concat(u).concat("!"));
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            System.out.println("Lo sentimos, no tiene acceso al sistema");
        }
    }
}
