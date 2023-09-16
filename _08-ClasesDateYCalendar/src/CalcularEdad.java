import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalcularEdad {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese su año de nacimiento (dd/MM/yyyy): ");
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = df.parse(entrada.next());
            
            Date fechaActual = new Date();
            
            long milisegundos = fechaActual.getTime() - fechaNacimiento.getTime();
            int edad = (int) (milisegundos / 31536000000L); // 31536000000L = 1000 * 60 * 60 * 24 * 365
            
            System.out.println("\nSu edad es de " + edad + " años");
            
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
