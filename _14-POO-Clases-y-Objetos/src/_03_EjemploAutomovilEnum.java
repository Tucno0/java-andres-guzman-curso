public class _03_EjemploAutomovilEnum {
    public static void main(String[] args) {
        Automovil.setCapacidadEstanqueEstatico(45);
        
        // Crear un objeto de la clase Automovil subaru
        Automovil subaru = new Automovil("Subaru", "Impreza");
        subaru.setColor(Color.BLANCO);
        subaru.setMotor(new Motor(2.0, TipoMotor.BENCINA));
        subaru.setEstanque(new Estanque());
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        // Crear un objeto de la clase Automovil mazda
        Automovil mazda = new Automovil("Mazda", "CX-5", Color.ROJO, new Motor(3.5, TipoMotor.DIESEL));
        mazda.setEstanque(new Estanque(45));
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println("mazda.getFabricante() = " + mazda.getFabricante());
        
        // Enums
        TipoAutomovil tipo = subaru.getTipo();
        System.out.println("\nTipo de subaru: " + tipo.getNombre());
        System.out.println("Descripción de subaru: " + tipo.getDescripcion());
        System.out.println("Número de puertas de subaru: " + tipo.getNumeroPuertas());

        tipo = mazda.getTipo();

        // Switch con enums
        switch (tipo) {
            case CONVERTIBLE -> System.out.println("El automovil es tipo convertible\n");
            case COUPE -> System.out.println("El automovil es tipo coupe\n");
            case FURGON -> System.out.println("El automovil es tipo furgón\n");
            case HATCHBACK -> System.out.println("El automovil es tipo hatchback\n");
            case PICKUP -> System.out.println("El automovil es tipo pickup\n");
            case SEDAN -> System.out.println("Subaru es seda\nn");
            case STATION_WAGON -> System.out.println("Subaru es station wagon\n");
            default -> System.out.println("Subaru es otro tipo de automóvil\n");
        }

        // Recorrer los valores del enum
        TipoAutomovil[] tipos = TipoAutomovil.values();
        for (TipoAutomovil t : tipos) {
            System.out.println(t + " -> " + t.name() +
                    "\n - " + t.getNombre() +
                    "\n - " + t.getDescripcion() +
                    "\n - " + t.getNumeroPuertas());
        }
    }
}
