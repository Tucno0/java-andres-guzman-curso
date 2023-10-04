package org.tucno.poointerfaces.repositorio.lista;

import org.tucno.poointerfaces.modelo.Cliente;
import org.tucno.poointerfaces.modelo.Producto;
import org.tucno.poointerfaces.repositorio.AbstractaListRepositorio;
import org.tucno.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);
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

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        resultado = switch (campo) {
            case "id" -> a.getId().compareTo(b.getId());
            case "descripcion" -> a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> a.getPrecio().compareTo(b.getPrecio());
            default -> resultado;
        };
        return resultado;
    }
}
