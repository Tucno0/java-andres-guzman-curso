import java.util.Date;

public class _02_EjemploAutomovilStatic {
    public static void main(String[] args) {
        // Crear un objeto de la clase Automovil
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor("Blanco");
        subaru.setCilindrada(2.0);

        // Crear un objeto de la clase Automovil
        Automovil mazda = new Automovil("Mazda", "CX-5", "Rojo", 3.0);

        // Crear un nuevo vehículo nissan
        Automovil nissan = new Automovil("Nissan", "Sentra", "Gris oscuro", 1.8, 50);

        // Crear un nuevo vehículo nissan2
        Automovil nissan2 = new Automovil("Nissan", "Sentra", "Gris oscuro", 1.8, 50);

        // Crear un nuevo vehículo auto
        Automovil auto = new Automovil();

        Automovil.setColorPlaca("verde");

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());
        
        // Métodos estáticos
        System.out.println("\n" + Automovil.getColorPlaca());
        System.out.println("Automovil.getColorPlaca() = " + Automovil.getColorPlaca());
        System.out.println("Kilometros por litros: " + Automovil.calcularConsumoEstatico(300, 60));
    }
}
