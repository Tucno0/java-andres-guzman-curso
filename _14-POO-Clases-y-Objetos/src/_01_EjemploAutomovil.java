import javax.xml.crypto.Data;
import java.util.Date;

public class _01_EjemploAutomovil {
    public static void main(String[] args) {
        // Crear un objeto de la clase Automovil
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setCilindrada(2.0);

        System.out.println(subaru.verDetalle());
        System.out.println(subaru.acelerarFrenar(3000));
        System.out.println("Kilómetros por litro: " + subaru.calcularConsumo(300, 0.6f));

        // Crear un objeto de la clase Automovil
        Automovil mazda = new Automovil("Mazda", "CX-5", Color.ROJO, 3.0);

        System.out.println(mazda.verDetalle());
        System.out.println(mazda.acelerarFrenar(3000));
        System.out.println("Kilómetros por litro: " + mazda.calcularConsumo(300, 60));

        // Crear un nuevo vehículo nissan
        Automovil nissan = new Automovil("Nissan", "Sentra", Color.GRIS, 1.8, 50);

        System.out.println(nissan.verDetalle());
        System.out.println("Kilómetros por litro: " + nissan.calcularConsumo(300, 60));

        // Crear un nuevo vehículo nissan2
        Automovil nissan2 = new Automovil("Nissan", "Sentra", Color.GRIS, 1.8, 50);

        // Crear un nuevo vehículo auto
        Automovil auto = new Automovil();

        // Date
        Date fecha = new Date();

        // El método equals compara si dos objetos son iguales
        System.out.println("\n¿Son iguales nissan y nissan2? " + (nissan == nissan2));
        System.out.println("¿Son iguales nissan y nissan2? " + nissan.equals(nissan2));
        System.out.println("¿Son iguales nissan y auto? " + auto.equals(nissan));

        System.out.println(auto.equals(fecha));

        // El metodo toString() retorna una cadena de caracteres con la representación del objeto
        System.out.println(nissan);
        System.out.println("\n" + nissan.toString());
    }
}
