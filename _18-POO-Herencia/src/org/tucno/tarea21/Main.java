package org.tucno.tarea21;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto de tipo Empleado
        Empleado empleado = new Empleado("Juan", "Pérez", "12345678", "Calle 123", 1000.0, 5);
        System.out.println(empleado);

        // Crear un objeto de tipo Gerente
        Gerente gerente = new Gerente("Pedro", "Gómez", "87654321", "Calle 321", 2000.0, 10, 10000.0);
        gerente.setPresupuesto(20000.0);
        gerente.aumentarSueldo(10.0);
        System.out.println(gerente);

        // Crear un objeto de tipo Cliente
        Cliente cliente = new Cliente("María", "García", "11111111", "Calle 111", 1);
        System.out.println(cliente);
    }
}
