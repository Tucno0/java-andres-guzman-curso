package org.tucno.poointerfaces.repositorio.lista;

import org.tucno.poointerfaces.modelo.Cliente;
import org.tucno.poointerfaces.repositorio.AbstractaListRepositorio;
import org.tucno.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        // Class anónima
        listaOrdenada.sort((o1, o2) -> {
            int resultado = 0;

            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, o1, o2);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, o2, o1);
            }
            return resultado;
        });

        return listaOrdenada;
    }

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
