package org.tucno.poointerfaces.repositorio;

import org.tucno.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir); // public abstract List<Cliente> listar(String campo, Direccion dir);

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        resultado = switch (campo) {
            case "id" -> a.getId().compareTo(b.getId());
            case "nombre" -> a.getNombre().compareTo(b.getNombre());
            case "apellido" -> a.getApellido().compareTo(b.getApellido());
            default -> resultado;
        };
        return resultado;
    }
}
