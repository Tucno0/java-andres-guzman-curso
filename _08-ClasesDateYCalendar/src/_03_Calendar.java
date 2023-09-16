import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class _03_Calendar {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance(); // Creamos un objeto de tipo Calendar
        
        // Primera forma de establecer una fecha en el calendario
//        calendario.set(2020, Calendar.SEPTEMBER, 25, 0, 0); // Establecemos la fecha del calendario
        
        // Segunda forma de establecer una fecha en el calendario
        calendario.set(Calendar.YEAR, 2020);
        calendario.set(Calendar.MONTH, Calendar.JULY);
        calendario.set(Calendar.DAY_OF_MONTH, 25);
        
        calendario.set(Calendar.HOUR_OF_DAY, 21);
        calendario.set(Calendar.MINUTE, 20);
        calendario.set(Calendar.SECOND, 10);
        
        Date fecha = calendario.getTime(); // Obtenemos la fecha del calendario
        System.out.println("fecha sin formato = " + fecha);
        
        // Formateamos la fecha
        SimpleDateFormat df = new SimpleDateFormat("dd MMMM, YYYY HH:mm:ss");
        String fechaStr = df.format(fecha);
        
        System.out.println("fecha con formato = " + fechaStr);
    }
}
