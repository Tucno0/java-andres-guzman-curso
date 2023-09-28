package org.tucno.tarea21;

public class Cliente extends Persona{
    private int clienteId;

    public Cliente(String nombre, String apellido, String numeroFiscal, String direccion, int clienteId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    // Sobre-escritura de métodos
    @Override
    public String toString() {
        return super.toString() +  // Llamada al método toString() de la clase padre
               "Cliente ID: " + this.clienteId + "\n";
    }
}
