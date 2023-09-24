import java.util.Arrays;

public class _05_EjemploAutomovilArreglo {
    public static void main(String[] args) {

        // Crear un objeto de la clase Automovil subaru
        Persona juan = new Persona("Juan", "Perez");
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(juan);

        // Crear un objeto de la clase Automovil mazda
        Persona lucy = new Persona("Lucy", "Gonzalez");
        Automovil mazda = new Automovil("Mazda", "CX-5", Color.ROJO, new Motor(3.5, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque());
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(lucy);

        // Crear un nuevo vehículo nissan
        Persona bea = new Persona("Beatriz", "Gonzalez");
        Automovil nissan = new Automovil("Nissan", "Sentra", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Estanque(50));
        nissan.setConductor(bea);
        nissan.setTipo(TipoAutomovil.PICKUP);

        // Crear un nuevo vehículo nissan2
        Persona leo = new Persona("Leonardo", "Gonzalez");
        Automovil susuki = new Automovil("Suzuki", "Vitara", Color.GRIS, new Motor(1.6, TipoMotor.BENCINA), new Estanque(50));
        susuki.setConductor(leo);
        susuki.setColor(Color.AMARILLO);
        susuki.setTipo(TipoAutomovil.SUV);
        Automovil.setColorPlaca(Color.AZUL);

        // Crear un nuevo vehículo audi
        Automovil audi = new Automovil("Audi", "A4", Color.GRIS, new Motor(2.0, TipoMotor.DIESEL), new Estanque(50));
        audi.setConductor(new Persona("Jano", "Perez"));


        // Arreglo de Automoviles
        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = susuki;
        autos[4] = audi;

        // Ordenar el arreglo de autos
        Arrays.sort(autos);

        // Recorrer el arreglo de autos
        System.out.println();
        for (Automovil auto : autos) {
            System.out.println(auto);
        }
    }
}
