import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _05_CompararFechas {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Ingrese la primera fecha (dd/MM/yyyy): ");
        try {
            Date fecha = df.parse(entrada.next());
            System.out.println("\nfecha son formato = " + fecha);
            System.out.println("Fecha con formato = " + df.format(fecha));
            
            Date fecha2 = new Date();
            System.out.println("\nfecha2 = " + fecha2);
            System.out.println("fecha2 con formato = " + df.format(fecha2));
            
            // Comparar fechas - forma 1
            if (fecha.after(fecha2)) {
                System.out.println("\nfecha (del usuario) es después que fecha2 (actual)");
            } else if (fecha.before(fecha2)) {
                System.out.println("\nfecha (del usuario) es antes que fecha2 (actual)");
            } else if (fecha.equals(fecha2)) {
                System.out.println("\nfecha (del usuario) es igual que fecha2 (actual)");
            }
            
            // Comparar fechas - forma 2
            // Devuelve 1 si fecha es después que fecha2, -1 si fecha es antes que fecha2, 0 si fecha es igual que fecha2
            if (fecha.compareTo(fecha2) > 0) {
                System.out.println("\nfecha (del usuario) es después que fecha2 (actual)");
            } else if (fecha.compareTo(fecha2) < 0) {
                System.out.println("\nfecha (del usuario) es antes que fecha2 (actual)");
            } else if (fecha.compareTo(fecha2) == 0) {
                System.out.println("\nfecha (del usuario) es igual que fecha2 (actual)");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
