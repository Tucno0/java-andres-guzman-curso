import java.text.SimpleDateFormat;
import java.util.Date; // Importamos la clase Date del paquete java.util que es para fechas con java, a diferencia de java.sql que es para fechas con SQL

public class _01_Date {
    public static void main(String[] args) {
        Date fecha = new Date(); // Creamos un objeto de tipo Date
        System.out.println("fecha = " + fecha);
        
        // Creamos un objeto de tipo SimpleDateFormat para darle formato a la fecha
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM, YYYY");
        // Otros formatos: dd/MM/YYYY, dd MMMM, YYYY HH:mm:ss, dd MMMM, YYYY hh:mm:ss a
        // https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        
        String fechaStr = df.format(fecha); // Le damos formato a la fecha
        System.out.println("fechaStr = " + fechaStr);
    }
}
