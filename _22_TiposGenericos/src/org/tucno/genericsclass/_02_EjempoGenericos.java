package org.tucno.genericsclass;

public class _02_EjempoGenericos {

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T objeto : camion) {
            if (objeto instanceof Animal) {
                Animal animal = (Animal) objeto;
                System.out.println("Nombre: " + animal.getNombre() + " Tipo: " + animal.getTipo());
            } else if (objeto instanceof Maquinaria) {
                Maquinaria maquinaria = (Maquinaria) objeto;
                System.out.println("Tipo: " + maquinaria.getTipo());
            } else if (objeto instanceof Automovil) {
                Automovil automovil = (Automovil) objeto;
                System.out.println("Marca: " + automovil.getMarca());
            }
        }
    }
    public static void main(String[] args) {

        // Transporte de caballos
        Camion<Animal> transporteCaballos = new Camion<>(5);

        transporteCaballos.add(new Animal("Pegaso", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        // Transporte de maquinas
        Camion<Maquinaria> transporteMaquinas = new Camion<>(5);
        transporteMaquinas.add(new Maquinaria("Excavadora"));
        transporteMaquinas.add(new Maquinaria("Retroexcavadora"));
        transporteMaquinas.add(new Maquinaria("Grúa"));
        transporteMaquinas.add(new Maquinaria("Bulldozer"));
        transporteMaquinas.add(new Maquinaria("Cargador Frontal"));

        System.out.println();
        imprimirCamion(transporteMaquinas);

        // Transporte de automoviles
        Camion<Automovil> transporteAutomoviles = new Camion<>(5);
        transporteAutomoviles.add(new Automovil("Toyota"));
        transporteAutomoviles.add(new Automovil("Nissan"));
        transporteAutomoviles.add(new Automovil("Mazda"));
        transporteAutomoviles.add(new Automovil("Suzuki"));
        transporteAutomoviles.add(new Automovil("Subaru"));

        System.out.println();
        imprimirCamion(transporteAutomoviles);
    }
}
