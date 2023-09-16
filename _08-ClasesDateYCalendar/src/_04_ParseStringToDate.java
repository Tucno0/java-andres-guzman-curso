import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _04_ParseStringToDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        
        System.out.print("Ingrese una fecha con el formato dd/MM/YYYY: ");
        Date fecha = format.parse(sc.next(), new java.text.ParsePosition(0));
        System.out.println("fecha = " + fecha);
        System.out.println("format.format(fecha) = " + format.format(fecha));
    }
}
