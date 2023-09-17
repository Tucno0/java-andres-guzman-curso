public class _04_EjemploAutomoviRelacionesObjetos {
    public static void main(String[] args) {

        // Crear un objeto de la clase Automovil subaru
        Rueda[] ruedasSubaru = new Rueda[5];
        ruedasSubaru[0] = new Rueda("Michelin", 18, 10.5);
        ruedasSubaru[1] = new Rueda("Michelin", 18, 10.5);
        ruedasSubaru[2] = new Rueda("Michelin", 18, 10.5);
        ruedasSubaru[3] = new Rueda("Michelin", 18, 10.5);
        ruedasSubaru[4] = new Rueda("Michelin", 18, 10.5);

        Persona juan = new Persona("Juan", "Perez");

        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(juan);
        subaru.setRuedas(ruedasSubaru);

        // Crear un objeto de la clase Automovil mazda
        Rueda[] ruedasMazda = {
                new Rueda("Yokohama", 16, 7.5),
                new Rueda("Yokohama", 16, 7.5),
                new Rueda("Yokohama", 16, 7.5),
                new Rueda("Yokohama", 16, 7.5),
                new Rueda("Yokohama", 16, 7.5),
        };

        Persona lucy = new Persona("Lucy", "Gonzalez");

        Automovil mazda = new Automovil("Mazda", "CX-5", Color.ROJO, new Motor(3.5, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque());
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(lucy);
        mazda.setRuedas(ruedasMazda);

        // Crear un nuevo vehículo nissan
        Rueda[] ruedasNissan = {
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
        };
        Persona bea = new Persona("Beatriz", "Gonzalez");
        Automovil nissan = new Automovil("Nissan", "Sentra", Color.GRIS, new Motor(4.0, TipoMotor.DIESEL), new Estanque(50), bea, ruedasNissan);
        nissan.setTipo(TipoAutomovil.PICKUP);

        // Crear un nuevo vehículo nissan2
        Rueda[] ruedasNissan2 = {
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
                new Rueda("Pirelli", 17, 8.5),
        };
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
