public class _04_EjemploAutomoviRelacionesObjetos {
    public static void main(String[] args) {

        // Crear un objeto de la clase Automovil subaru
        Persona juan = new Persona("Juan", "Perez");

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(juan);
//        subaru.setRuedas(ruedasSubaru);

        Rueda[] ruedasSubaru = new Rueda[5];
        for (int i = 0; i < ruedasSubaru.length; i++) {
            subaru.addRueda(new Rueda("Michelin", 17, 8.5));
        }

        // Crear un objeto de la clase Automovil mazda
        Persona lucy = new Persona("Lucy", "Gonzalez");

        Automovil mazda = new Automovil("Mazda", "CX-5", Color.ROJO, new Motor(3.5, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque());
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(lucy);
//        mazda.setRuedas(ruedasMazda);

        Rueda[] ruedasMazda = new Rueda[5];
        for (int i = 0; i < ruedasMazda.length; i++) {
            mazda.addRueda(new Rueda("Yokohama", 16, 7.5));
        }

        // Crear un nuevo vehículo nissan
        Rueda[] ruedasNissan = new Rueda[5];
        for (int i = 0; i < ruedasNissan.length; i++) {
            ruedasNissan[i] = new Rueda("Pirelli", 17, 8.5);
        }
        Persona bea = new Persona("Beatriz", "Gonzalez");
        Automovil nissan = new Automovil("Nissan", "Sentra", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Estanque(50), bea, ruedasNissan);
        nissan.setTipo(TipoAutomovil.PICKUP);

        // Crear un nuevo vehículo nissan2
        Rueda[] ruedasNissan2 = new Rueda[5];
        for (int i = 0; i < ruedasNissan2.length; i++) {
            ruedasNissan2[i] = new Rueda("Pirelli", 17, 8.5);
        }
        Persona leo = new Persona("Leonardo", "Gonzalez");
        Automovil nissan2 = new Automovil("Nissan", "Sentra", Color.GRIS, new Motor(3.5, TipoMotor.BENCINA), new Estanque(50), leo, ruedasNissan2);
        nissan2.setTipo(TipoAutomovil.PICKUP);

        // Crear un nuevo vehículo auto
        Automovil auto = new Automovil();

        Automovil.setColorPlaca(Color.VERDE);

        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        // Mostrando ruedas de subaru
        System.out.println("\nConduciendo subaru: " + subaru.getConductor());
        System.out.println("Ruedas de subaru:");
        for (Rueda rueda : subaru.getRuedas()) {
            System.out.println(rueda.getFabricante() + " aro: " + rueda.getAro() + " ancho: " + rueda.getAncho());
        }

    }
}
